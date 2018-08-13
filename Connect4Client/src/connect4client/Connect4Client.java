/**
 * @author Justin Doty
 * Client program that sends and listens to packets to and from the server
 */
package connect4client;

import java.awt.Point;
import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect4Client extends Thread{

    private final static int  DEST_PORT = 5936;
    private final static String SERVER_NAME = "localhost";
    private Socket clientSocket;
    private LobbyGUI lobbyGUI;
    private GameGUI gameGUI;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String serverResponse;
    private String playerName;
    private int playerID;
    private String possibleOpponent;
    private HashMap<Integer, String> playerList;
    
    public Connect4Client() throws IOException {
        try{
            clientSocket = new Socket(InetAddress.getByName(SERVER_NAME), DEST_PORT);
            
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            
            System.out.println("Joined connect 4 server");
        }catch (SocketException e) {
                System.out.println("Server is not responding");
                System.exit(0);
	}
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Listening for packets from server..");
            
            initLobbyGUI();
            
            while(true) {
                getServerPacket();
                
                checkCommonPacket();
                checkLobbyPacket();
                checkGamePacket();
            }
        } catch (IOException ex) {
            Logger.getLogger(Connect4Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect4Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Connect4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*********************************************************************************/
    /******************************Start Common Code**********************************/
    /*********************************************************************************/
    
    private void initLobbyGUI() throws IOException, ClassNotFoundException {
        lobbyGUI = new LobbyGUI(this);
        lobbyGUI.setVisible(true);
        
        initPlayerName();
    }
    
    private void initPlayerName() throws IOException, ClassNotFoundException {
        playerName = (String)in.readObject();
        playerID = (int)in.readObject();
        
        lobbyGUI.PlayerName.setText(playerName);
    }
    
    private void getServerPacket() throws IOException, ClassNotFoundException {
        try {
            serverResponse = (String)in.readObject();   
        } catch(SocketException e) {}
    }
    
    private void checkCommonPacket() throws IOException, ClassNotFoundException {
        if(serverResponse.startsWith("UPDATE_LIST"))
            updatePlayerList();
    }
    
    private void updatePlayerList() throws IOException, ClassNotFoundException {
        System.out.println("Received packet: updated player list");
        
        try {
            playerList = (HashMap<Integer, String>)in.readObject();  
        } catch(SocketException e) {}

        lobbyGUI.updatePlayerButtons(playerList, playerName);
    }
    
    protected void sendMessage(Object message) throws IOException {
        out.writeObject(message);
        out.reset();
    }
    
    protected int getPlayerID() {
        return playerID;
    }
    
    /********************************************************************************/
    /******************************End Common Code***********************************/
    /********************************************************************************/
    
    /*********************************************************************************/
    /******************************Start Lobby Code***********************************/
    /*********************************************************************************/
    
    private void checkLobbyPacket() {
        if(serverResponse.startsWith("SET_NAME"))
            updateName();
        else if(serverResponse.startsWith("REQUEST"))
            proccessRequest();
        else if(serverResponse.startsWith("ACCEPTED_REQUEST"))
            initGameGUI();
        else if(serverResponse.startsWith("CANCEL_REQUEST"))
            cancelRequest();
        else if(serverResponse.startsWith("BUSY"))
            showBusyPopup();
    }
    
    private void updateName() {
        playerName = serverResponse.substring(8,serverResponse.length());
        lobbyGUI.updatePlayerName(playerName);
    }
    
    private void proccessRequest() {
        possibleOpponent = serverResponse.substring(7, serverResponse.length());

        System.out.println("Received packet: request game from " + possibleOpponent);
        
        lobbyGUI.showRequestPopup(possibleOpponent);
    }
    
    protected void initGameGUI() {
        gameGUI = new GameGUI(this, lobbyGUI);
        gameGUI.setLocation(lobbyGUI.getLocation());
        
        lobbyGUI.putUpLobbyGUI();
        
        gameGUI.setVisible(true);
    }
    
    private void cancelRequest() {
        System.out.println("Received packet: cancel request from " + possibleOpponent);
        
        lobbyGUI.makePlayerButtonsVisible();
    }
    
    private void showBusyPopup() {
        String busyPlayer = serverResponse.substring(4, serverResponse.length());
        
        lobbyGUI.makeBusyPopupVisible(busyPlayer);
    }
    
    /*******************************************************************************/
    /******************************End Lobby Code***********************************/
    /*******************************************************************************/
    
    /********************************************************************************/
    /******************************Start Game Code***********************************/
    /********************************************************************************/
    
    private void checkGamePacket() throws InterruptedException {
        if(serverResponse.startsWith("INITIALIZE_GAME"))
            initGame();
        else if(serverResponse.startsWith("VALID_MOVE"))
            processPlayerMove();
        else if(serverResponse.startsWith("OPPONENT_TURN"))
            processOpponentMove();
        else if(serverResponse.startsWith("INVALID_MOVE"))
            processInvalidMove();
        else if(serverResponse.startsWith("END_GAME"))
            endGame();
        else if(serverResponse.startsWith("TIE_GAME"))
            processTieGame();
        else if(serverResponse.startsWith("TIMED_OUT"))
            processOpponentTimeOut();
        else if(serverResponse.startsWith("REMATCH"))
            processRematch();
        else if(serverResponse.startsWith("DECLINED_REMATCH"))
            declineRematch();
    }
    
    private void initGame() {
        boolean turn = "1".equals(serverResponse.substring(15, 16));
        String opponentName = serverResponse.substring(16, serverResponse.length());

        gameGUI.initGame(turn, playerName, opponentName);
    }
    
    private void processPlayerMove() throws InterruptedException {
        int column = Integer.parseInt(serverResponse.substring(10, 11));
        int row = Integer.parseInt(serverResponse.substring(11, 12));

        gameGUI.playPlayerChip(row, column);
    }
    
    private void processOpponentMove() throws InterruptedException {
        int column = Integer.parseInt(serverResponse.substring(13, 14));
        int row = Integer.parseInt(serverResponse.substring(14, 15));

        gameGUI.playeOpponentChip(row, column);
    }
    
    private void processInvalidMove() {
        gameGUI.playInvalidSound();
    }
    
    private void endGame() throws InterruptedException, InterruptedException {
        gameGUI.displayEndGameOptions();
        
        String determ = serverResponse.substring(8, 9);
        int column = Integer.parseInt(serverResponse.substring(9, 10));
        int row = Integer.parseInt(serverResponse.substring(10, 11));

        if(determ.equals("1"))
            displayWinResult(row, column);
        else
            displayLoseResult(row, column);
    }
    
    private void displayWinResult(int column, int row) throws InterruptedException {
        gameGUI.displayWinResult(column, row);
        gameGUI.playCheerSound();
    }
    
    private void displayLoseResult(int column, int row) throws InterruptedException {
        gameGUI.displayLoseResult(column, row);
        gameGUI.playLoseSound();
    }
    
    private void processTieGame() {
        gameGUI.displayEndGameOptions();
        
        String determ = serverResponse.substring(8, 9);
        int column = Integer.parseInt(serverResponse.substring(9, 10));
        int row = Integer.parseInt(serverResponse.substring(10, 11));

        if(determ.equals("1"))
            gameGUI.displayTieResultPlayer(row, column);
        else
            gameGUI.displayTieResultOpponent(row, column);

        gameGUI.displayTieText();
    }
    
    private void processOpponentTimeOut() {
        gameGUI.resetPlayerPiece();
        gameGUI.displayTimeOutPopup();
    }
    
    private void processRematch() {
        Point location = gameGUI.getLocation();
        gameGUI.putUpGameGUI();
        
        gameGUI = new GameGUI(this, lobbyGUI);
        gameGUI.setLocation(location);
        gameGUI.setVisible(true);
    }
    
    private void declineRematch() {
        gameGUI.displayDeclinedText();
    }
    
    protected void setPossibleOpponent(String possibleOpponent) {
        this.possibleOpponent = possibleOpponent;
    }
    
    protected String getPossibleOpponent() {
        return possibleOpponent;
    }
    
    /******************************************************************************/
    /******************************End Game Code***********************************/
    /******************************************************************************/
    
    /********************************************************************************/
    /******************************Start Main Code***********************************/
    /********************************************************************************/
    
    public static void main(String[] args) throws IOException {
        Connect4Client client = new Connect4Client();
        client.start();
    }
    
    /******************************************************************************/
    /******************************End Main Code***********************************/
    /******************************************************************************/
    
}