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
 * Created by Carin on 10/2/2015.
 */
public class ReactionTimerController {

    // Lazy singleton
    private static ReactionTimeList reactionTimeList = null;
    static public ReactionTimeList getReactionTimeList() {
        if (reactionTimeList == null) {
            reactionTimeList = new ReactionTimeList();
        }
        return reactionTimeList;
    }

    public void addReactionTime(int reactionTime) {
        getReactionTimeList().addReactionTime(reactionTime);
    }

    public int getReactionTime(int i) {
        return getReactionTimeList().getReactionTime(i);
    }

}
