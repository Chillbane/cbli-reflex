package ca.ualberta.cs.cbli_reflex;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Carin on 10/4/2015.
 */
public class Game {

    protected List<Player> playerList = new ArrayList<Player>();
    protected int numOfPlayers = 0;

    public Game(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        for(int i = 0; i < numOfPlayers; i++) {
            playerList.add(new Player());
        }
    }

    public void addBuzz(int playerNum){
        playerList.get(playerNum - 1).increaseBuzzerCount();
    }

    public int getBuzzes(int playerNum) {
        return playerList.get(playerNum - 1).getBuzzerCount();
    }

    public boolean isEmpty() {
        return playerList.isEmpty();
    }

    public void clearBuzzes() {
        if (numOfPlayers != 0) {
            for (int i = 0; i < numOfPlayers; i++) {
                playerList.get(i).clearBuzzerCount();
            }
        }
    }

}
