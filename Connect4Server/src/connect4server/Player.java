/**
 * @author Justin Doty
 * Class that houses the communication attributes for a player.
 */
package connect4server;

import java.io.*;
import java.net.*;

public class Player {
    
    private int ID;
    private String name;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean inGame = false;
    private boolean busy = false;
    private static int playerCounter = 1;
    
    public Player(Socket clientSocket) throws IOException {
        name = "Player" + playerCounter;
        ID = playerCounter;
        
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
        
        
        playerCounter++;
    }
    
    public String getName() { return name; }
    
    public int getID() { return ID; }
    
    public boolean isBusy() { return busy; }
    
    public boolean isInGame() { return inGame; }

    public ObjectInputStream getIn() { return in; }

    public ObjectOutputStream getOut() { return out; }
    
    public void setInGame(boolean inGame) { this.inGame = inGame; }
    
    public void setBusy(boolean busy) { this.busy = busy; }
    
    public boolean setName(String name) {
        if(name.length() == 0)
            return true;
        if(name.length() < 9) {
            this.name = name;
            return true;
        }
        return false;
    }
    
}