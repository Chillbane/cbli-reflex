/*
Student Picker: Randomly pick students to answer questions

Copyright (C) 2015 Carin Li Abram Hindle abram.hindle@softwareprocess.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package ca.ualberta.cs.cbli_reflex;

/*
 * Created by Carin on 10/4/2015.
 */

public class GameShowBuzzerController {

    // Lazy singletons
    private static Game twoPlayerGame = null;
    private static Game threePlayerGame = null;
    private static Game fourPlayerGame = null;

    static public Game getGame(int numOfPlayers) {
        if (numOfPlayers == 2) {
            if (twoPlayerGame == null) {
                twoPlayerGame = new Game(numOfPlayers);
            }
            return twoPlayerGame;
        }else if (numOfPlayers == 3) {
            if (threePlayerGame == null) {
                threePlayerGame = new Game(numOfPlayers);
            }
            return threePlayerGame;
        }else {
            if (fourPlayerGame == null) {
                fourPlayerGame = new Game(numOfPlayers);
            }
            return fourPlayerGame;
        }
    }

    public void addBuzz(int numOfPlayers, int playerNum) {
        getGame(numOfPlayers).addBuzz(playerNum);
    }

    public int getBuzzes(int numOfPlayers, int playerNum) {
        return  getGame(numOfPlayers).getBuzzes(playerNum);
    }

}
