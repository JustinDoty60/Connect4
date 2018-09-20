/**
 * @author Justin Doty
 * Server program that sends and listens to packets to and from players that are currently connected. Can
 * only have 9 clients at a time that it is listening from.
 */
package connect4server;

import java.net.*;
import java.io.*;
import java.util.*;

public class Connect4Server extends Thread {

    private static ArrayList<Connect4Server> playerThreads = new ArrayList<>();
    private static int numPlayers = 0;
    private Player player;
    private Player opponent;
    private boolean running;
    private String clientResponse;
    private int chipsPlayed = 0;
    private int inARowCount = 0;
    private boolean rematch = false;
    private Player[][] board = {{null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null}};
    
    public Connect4Server(Player newPlayer) {
        this.player = newPlayer;
        this.running = true;
        this.start();
    }
    
    @Override
    public void run() { //Waits for and processes packets from clients
        try {
            while(running) {
                getClientPacket();
                
                checkCommonPacket();
                checkLobbyPacket();
                checkGamePacket();
            }
        }catch (IOException | ClassNotFoundException | InterruptedException e) {
            System.out.println("Error found - exiting");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    /*********************************************************************************/
    /******************************Start Common Code**********************************/
    /*********************************************************************************/
    
    private void checkCommonPacket() throws IOException { //Checks whether an incoming packet is a common packet, if so it is processes
        if(clientResponse.equals("LEAVE"))
            terminatePlayer();
    }
    
    private void terminatePlayer() throws IOException { //Terminates player references in server and sends an updated list to all clients
        removePlayerThread();
        numPlayers--;
        running = false;

        System.out.println(player.getName() + " left the server");

        updateLobbyLists();
    }
    
    private void removePlayerThread() { //Terminates the player's thread from the server's client list
        List<Connect4Server> list = playerThreads;
        for(Iterator<Connect4Server> iter = list.iterator(); iter.hasNext();) {
            Connect4Server temp = iter.next();
            if(temp.player.getID() == player.getID()) {
                iter.remove();
                return;
            }
        }
    }
    
    private void updateLobbyLists() throws IOException { //Sends current players list to all clients
        HashMap<Integer, String> playerList = new HashMap<>();
        for(Connect4Server currPlayerThread: playerThreads)
            playerList.put(currPlayerThread.player.getID(), currPlayerThread.player.getName());
        
        for(Connect4Server currPlayerThread: playerThreads) {
            sendMessage(currPlayerThread.player, "UPDATE_LIST");
            sendMessage(currPlayerThread.player, playerList);
        }
    }
    
    private static void sendMessage(Player source, Object message) throws IOException { //Sends a message to a specific client
        source.getOut().writeObject(message);
        source.getOut().reset();
    }
    
    private void sendSimpleResponse(Player player, String message) throws IOException { //Sends a message to a specific client to a client's thread
        for(Connect4Server currPlayerThread: playerThreads) {
            if(currPlayerThread.player.getID() == player.getID()) {
                sendMessage(currPlayerThread.player, message);
                break;
            }
        }
    }
    
    private void sendStatusResponse(String message) throws IOException, ClassNotFoundException { //Sends a busy or not busy status message to a specific client 
        sendSimpleResponse(player, message + opponent.getName() );
    }
    
    private synchronized void getClientPacket() throws IOException, ClassNotFoundException { //Waits for a client's reponse and takes it in as a String
        clientResponse = (String) player.getIn().readObject();
    }
    
    private void resetBoard() { //Resets the game's board to all NULL 
        chipsPlayed = 0;
        
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++)
                board[i][j] = null;
        }
    }
    
    /********************************************************************************/
    /******************************End Common Code***********************************/
    /********************************************************************************/
    
    /*********************************************************************************/
    /******************************Start Lobby Code***********************************/
    /*********************************************************************************/
    
    private void checkLobbyPacket() throws IOException, ClassNotFoundException { //Checks whether an incoming packet is a lobby packet, if so it is processes
        if(clientResponse.startsWith("SET_NAME"))
            determineValidName();
        else if(clientResponse.startsWith("REQUEST"))
            processGameRequest();
        else if(clientResponse.startsWith("ACCEPT_REQUEST"))
            initGame();
        else if(clientResponse.startsWith("CANCEL_REQUEST"))
            cancelGameRequest();
        else if(clientResponse.startsWith("BUSY"))
            sendStatusResponse("BUSY");
    }
    
    private void determineOpponent(String opponentName) { //Determines what the client's opponent's name is
            opponent = getOpponentThread(opponentName).player;
            opponent.setName(opponentName);
    }
    
    private Connect4Server getOpponentThread(String opponentName) { //Returns opponent's Thread for communication purposes
        for(Connect4Server possibleOpponent: playerThreads) {
            if(possibleOpponent.player.getName().equals(opponentName))
                return possibleOpponent;
        }
        return null;
    }
    
    private Connect4Server getOpponentThread() { //Returns opponent's Thread for communication purposes
        for(Connect4Server possibleOpponent: playerThreads) {
            if(possibleOpponent.player.equals(opponent))
                return possibleOpponent;
        }
        return null;
    }
    
    private void determineValidName() throws IOException { //Determines whether the client's given name is a valid name
        if(isLobbyFull()) return;
        
        String name = clientResponse.substring(8,clientResponse.length());
                    
        if(player.setName(name)) {
            playerThreads.add(this);
            numPlayers++;
            sendName();
            updateLobbyLists();
        } else 
            sendMessage(player, "BAD_NAME");
    }
    
    private void sendName() throws IOException { //Sends a packet to the client with their assigned valid name
        sendMessage(player, "SET_NAME" + player.getName());

        System.out.println(player.getName() + " joined the server");
    }
    
    private void processGameRequest() throws IOException { //Checks whether the client's opponent is busy. If they are, a busy message is sent. If not, a request message is sent to the opponent
        String opponentName = clientResponse.substring(7, clientResponse.length());
        determineOpponent(opponentName);
        
        System.out.println("Received Request: FROM/" + player.getName() + "\tTO/" + opponent.getName());

        if(!opponent.isBusy()) {
            if(!opponent.isInGame()) {
                getOpponentThread().determineOpponent(player.getName());
                player.setBusy(true);
                opponent.setBusy(true);
                sendMessage(opponent, "REQUEST" + player.getName());
                return;
            }
        }
        sendMessage(player, "BUSY" + opponent.getName());
    }
    
    private void initGame() throws IOException {System.out.println("Initializing Game between " + player.getName() + " and " + opponent.getName()); //Sends an indicator message to opponent to trigger game GUI, then inits game variables
        
        sendMessage(opponent, "ACCEPTED_REQUEST" + player.getName());

        player.setBusy(false);
        opponent.setBusy(false);
        player.setInGame(true);
        opponent.setInGame(true);

        determineInitTurn();
    }
    
    private void determineInitTurn() throws IOException { //Determines the initial turn in a game
        if(Math.random() > .5) 
            sendInitTurn("INITIALIZE_GAME0", "INITIALIZE_GAME1");
        else
            sendInitTurn("INITIALIZE_GAME1", "INITIALIZE_GAME0");
    }
    
    private void sendInitTurn(String opponentMessage, String playerMessage) throws IOException { //Sends a message to both players in a game to set the initial turn
        sendMessage(opponent, opponentMessage + player.getName());
        sendMessage(player, playerMessage + opponent.getName());
    }
    
    private void cancelGameRequest() throws IOException {
        String alertPlayer = clientResponse.substring(14, clientResponse.length());
        System.out.println(alertPlayer);
        
        player.setBusy(false);
        opponent.setBusy(false);

        sendSimpleResponse(opponent, "CANCEL_REQUEST");
    }
    
    private boolean isLobbyFull() throws IOException {
        if(numPlayers >= 9) {
            sendMessage(player, "SERVER_BUSY");
            return true;
        }
        return false;
    }
    
    /*******************************************************************************/
    /******************************End Lobby Code***********************************/
    /*******************************************************************************/
    
    /********************************************************************************/
    /******************************Start Game Code***********************************/
    /********************************************************************************/
    
    private void checkGamePacket() throws IOException, InterruptedException { //Checks whether an incoming packet is a game packet, if so it is processes
        if(clientResponse.startsWith("MOVE")) 
            processMove();
        else if(clientResponse.startsWith("REMATCH"))
            processRematch();
        else if(clientResponse.startsWith("DECLINE_REMATCH"))
            processDeclinedRematch();
        else if(clientResponse.startsWith("TIMED_OUT"))
            processTimeOut();
    }
    
    private void processMove() throws IOException {
        int column = Integer.parseInt(clientResponse.substring(4, 5));

        if(isValidMove(column)) {
            increaseChipsPlayed();
            determineValidMoveResponse(column);
        } else
            sendMessage(player, "INVALID_MOVE");
    }
      
    private void increaseChipsPlayed() {
        chipsPlayed++;
        getOpponentThread().chipsPlayed++;
    }
    
    private void determineValidMoveResponse(int column) throws IOException {
        int playPos = findRowPosition(column);
        setChip(playPos, column);
            
        if(isEndGame())
            sendValidMoveResponse("END_GAME1", "END_GAME0", column, playPos);
        else if(isDraw())
            sendValidMoveResponse("TIE_GAME1", "TIE_GAME0", column, playPos);
        else
            sendValidMoveResponse("VALID_MOVE", "OPPONENT_TURN", column, playPos);
    }
    
    private void sendValidMoveResponse(String playerMessage, String opponentMessage, int column, int playPos) throws IOException {
        sendMessage(player, playerMessage + column + playPos);
        sendMessage(opponent, opponentMessage + column + playPos);
    }
    
    private void processRematch() throws IOException {
        rematch = true;
        resetBoard();
        
        if(getOpponentThread().rematch) {
            resetRematch();
            sendMessage(player, "REMATCH0");
            sendMessage(opponent, "REMATCH1");
            determineInitTurn();
        }
    }
    
    private void resetRematch() {
        rematch = false;
        getOpponentThread().rematch = false;
    }
    
    private void processDeclinedRematch() throws IOException {
        resetBoard();
        player.setInGame(false);
        
        if(isOpponentAvailable())
            sendMessage(opponent, "DECLINED_REMATCH");
    }
    
    private void processTimeOut() throws IOException {
        resetBoard();
        
        if(isOpponentAvailable())
            sendMessage(opponent, "TIMED_OUT");
    }
    
    private boolean isOpponentAvailable() {
        for(Connect4Server currPlayerThread: playerThreads) {
            if(currPlayerThread.player.equals(opponent))
                return true;
        }
        return false;
    }
    
    private int findRowPosition(int column) {
        int columnPosBefore = -1;
        for(int i = 1; i < 6; i++) {
            columnPosBefore = i - 1;
            if(board[i][column] != null)
                return columnPosBefore;
        }
        return 5;    
    }
    
    private void setChip(int row, int column) {
        board[row][column] = player;
        getOpponentThread().board[row][column] = player;
    }
    
    private boolean isValidMove(int column) {
        return !(board[0][column] != null);
    }
    
    private boolean isEndGame() {
        return checkVertical() || checkHorizontal() || checkDiagonals();
    }
    
    private boolean isDraw() {
        return chipsPlayed == 42;
    }
    
    private boolean checkVertical() {
        for(int i = 0; i < 7; i++) {
            inARowCount = 0;
            for(int j = 0; j < 6; j++) {
                if(board[j][i] != null && board[j][i].equals(player))
                    inARowCount++;
                else
                    inARowCount = 0;
                
                if(inARowCount == 4)
                    return true;
            }
        }
        return false;
    }
    
    private boolean checkHorizontal() {
        for(int i = 0; i < 6; i++) {
            inARowCount = 0;
            for(int j = 0; j < 7; j++) {
                if(board[i][j] != null && board[i][j].equals(player))
                    inARowCount++;
                else
                    inARowCount = 0;
                
                if(inARowCount == 4)
                    return true;
            }
        }
        return false;
    }
    
    private boolean checkDiagonals() {
        return checkDiagonalLeftRightUp(3, 0, 0) || checkDiagonalLeftRightUp(4, 0, 0)
            || checkDiagonalLeftRightUp(5, 0, 0) || checkDiagonalLeftRightUp(5, 1, 0)
            || checkDiagonalLeftRightUp(5, 2, 1) || checkDiagonalLeftRightUp(5, 3, 2)
            || checkDiagonalRightLeftUp(5, 3, 2) || checkDiagonalRightLeftUp(5, 4, 1)
            || checkDiagonalRightLeftUp(5, 5, 0) || checkDiagonalRightLeftUp(5, 6, 0)
            || checkDiagonalRightLeftUp(4, 6, 0) || checkDiagonalRightLeftUp(3, 6, 0);
    }
    
    private boolean checkDiagonalLeftRightUp(int startRow, int startColumn, int endRow) {
        inARowCount = 0;
        for(int i = startRow, j = startColumn; i >= endRow; i--,j++) {
            if(board[i][j] != null && board[i][j].equals(player))
                inARowCount++;
            else
                inARowCount = 0;

            if(inARowCount == 4)
                return true;
        }
        return false;
    }
    
    private boolean checkDiagonalRightLeftUp(int startRow, int startColumn, int endRow) {
        inARowCount = 0;
        for(int i = startRow, j = startColumn; i >= endRow; i--,j--) {
            if(board[i][j] != null && board[i][j].equals(player))
                inARowCount++;
            else
                inARowCount = 0;

            if(inARowCount == 4)
                return true;
        }
        return false;
    }
    
    /******************************************************************************/
    /******************************End Game Code***********************************/
    /******************************************************************************/
    
    /********************************************************************************/
    /******************************Start Main Code***********************************/
    /********************************************************************************/
    
    private static void checkPortNum(String[] portNum) { //Checks whether the args provided are valid
        if(portNum.length != 1) {
            System.out.println("Port number is required, exiting");
            System.exit(-1);
        }
    }
    
    private static void acceptClients(ServerSocket serverJoinSocket) throws IOException { //Waits and accepts clients and initalizes them
        while(true) {
            Socket clientSocket = serverJoinSocket.accept();
            
            initNewPlayer(clientSocket);
        }
    }
    
    private static void initNewPlayer(Socket clientSocket) throws IOException { //Creates a new thread in the server for the new client and sends a message to client with their initial name and ID
        Player newPlayer = new Player(clientSocket);
        sendMessage(newPlayer, newPlayer.getName());
        sendMessage(newPlayer, newPlayer.getID());
        new Connect4Server(newPlayer);
    }
    
    public static void main(String[] args) throws IOException {
        checkPortNum(args);
        
        ServerSocket serverJoinSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server running..");

        acceptClients(serverJoinSocket);
    }
    
    /******************************************************************************/
    /******************************End Main Code***********************************/
    /******************************************************************************/
    
} 