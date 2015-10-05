/*
   cbli-reflex: Android app with reaction timer and game show buzzer modes
   Copyright 2015 Carin Li

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package ca.ualberta.cs.cbli_reflex;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Carin on 10/4/2015.
 *
 * This class represents a buzzer game by storing a list of Players.
 */
public class Game {

    protected List<Player> playerList = new ArrayList<Player>();
    protected int numOfPlayers = 0;

    // Adds the specified number of players to the game
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
