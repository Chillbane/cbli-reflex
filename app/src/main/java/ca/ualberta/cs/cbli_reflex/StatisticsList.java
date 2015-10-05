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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Created by Carin on 10/4/2015.
 *
 * This class generates all statistics for output to Statistics Activity using the
 * ReactionTimerController and GameShowBuzzerController.
 */
public class StatisticsList {
    protected List<String> statisticsList = new ArrayList<String>();

    private ReactionTimerController rtc = new ReactionTimerController();
    private GameShowBuzzerController gsbc = new GameShowBuzzerController();
    private int numItems = rtc.getTotalTimes();

    // populate statisticsList with statistics
    public StatisticsList() {
        clearStatistics();
        minReactionTime();
        maxReactionTime();
        avgReactionTime();
        medReactionTime();
        twoPlayerGameBuzzes();
        threePlayerGameBuzzes();
        fourPlayerGameBuzzes();
    }

    public List<String> getStatistics() {
        return statisticsList;
    }

    // Generates minimum reaction time stats
    public void minReactionTime() {
        int ofAllTimes;
        int lastTenTimes;
        int lastHundredTimes;

        if (rtc.isEmpty()) {
            statisticsList.add("Minimum time of all reaction times: ");
            statisticsList.add("Minimum time of last ten reaction times: ");
            statisticsList.add("Minimum time of last hundred reaction times: ");
        }else {

            ofAllTimes = getMin(0, numItems - 1);
            lastTenTimes = ofAllTimes;
            lastHundredTimes = ofAllTimes;
            if ((numItems >= 10) && (numItems < 100)) {
                lastTenTimes = getMin(numItems - 10, numItems - 1);
            } else if (numItems >= 100){
                lastTenTimes = getMin(numItems - 10, numItems - 1);
                lastHundredTimes = getMin(numItems - 100, numItems - 1);
            }
        statisticsList.add("Minimum time of all reaction times: " + ofAllTimes);
        statisticsList.add("Minimum time of last ten reaction times: " + lastTenTimes);
        statisticsList.add("Minimum time of last hundred reaction times: " + lastHundredTimes);
        }
    }

    // Generates maximum reaction time stats
    public void maxReactionTime() {
        int ofAllTimes;
        int lastTenTimes;
        int lastHundredTimes;

        if (rtc.isEmpty()) {
            statisticsList.add("Maximum time of all reaction times: ");
            statisticsList.add("Maximum time of last ten reaction times: ");
            statisticsList.add("Maximum time of last hundred reaction times: ");
        }else {

            ofAllTimes = getMax(0, numItems - 1);
            lastTenTimes = ofAllTimes;
            lastHundredTimes = ofAllTimes;
            if ((numItems >= 10) && (numItems < 100)) {
                lastTenTimes = getMax(numItems - 10, numItems - 1);
            } else if (numItems >= 100){
                lastTenTimes = getMax(numItems - 10, numItems - 1);
                lastHundredTimes = getMax(numItems - 100, numItems - 1);
            }
            statisticsList.add("Maximum time of all reaction times: " + ofAllTimes);
            statisticsList.add("Maximum time of last ten reaction times: " + lastTenTimes);
            statisticsList.add("Maximum time of last hundred reaction times: " + lastHundredTimes);
        }
    }

    // Generates average reaction time stats
    public void avgReactionTime() {
        int ofAllTimes;
        int lastTenTimes;
        int lastHundredTimes;

        if (rtc.isEmpty()) {
            statisticsList.add("Average time of all reaction times: ");
            statisticsList.add("Average time of last ten reaction times: ");
            statisticsList.add("Average time of last hundred reaction times: ");
        }else {

            ofAllTimes = getAvg(0, numItems - 1);
            lastTenTimes = ofAllTimes;
            lastHundredTimes = ofAllTimes;
            if ((numItems >= 10) && (numItems < 100)) {
                lastTenTimes = getAvg(numItems - 10, numItems - 1);
            } else if (numItems >= 100){
                lastTenTimes = getAvg(numItems - 10, numItems - 1);
                lastHundredTimes = getAvg(numItems - 100, numItems - 1);
            }
            statisticsList.add("Average time of all reaction times: " + ofAllTimes);
            statisticsList.add("Average time of last ten reaction times: " + lastTenTimes);
            statisticsList.add("Average time of last hundred reaction times: " + lastHundredTimes);
        }
    }

    // Generates median reaction time stats
    public void medReactionTime() {
        double ofAllTimes;
        double lastTenTimes;
        double lastHundredTimes;

        if (rtc.isEmpty()) {
            statisticsList.add("Median time of all reaction times: ");
            statisticsList.add("Median time of last ten reaction times: ");
            statisticsList.add("Median time of last hundred reaction times: ");
        } else {
            ofAllTimes = getMed(0, numItems - 1);
            lastTenTimes = ofAllTimes;
            lastHundredTimes = ofAllTimes;
            if ((numItems >= 10) && (numItems < 100)) {
                lastTenTimes = getMed(numItems - 10, numItems - 1);
            } else if (numItems >= 100){
                lastTenTimes = getMed(numItems - 10, numItems - 1);
                lastHundredTimes = getMed(numItems - 100, numItems - 1);
            }
            statisticsList.add("Median time of all reaction times: " + ofAllTimes);
            statisticsList.add("Median time of last ten reaction times: " + lastTenTimes);
            statisticsList.add("Median time of last hundred reaction times: " + lastHundredTimes);
        }
    }

    // Gets minimum reaction time
    public int getMin(int startIndex, int endIndex){
        int minValue = rtc.getReactionTime(startIndex);
        int currentValue;

        for(int i = startIndex; i <= endIndex; i++) {
            currentValue = rtc.getReactionTime(i);
            if (currentValue < minValue) {
                minValue = currentValue;
            }
        }

        return minValue;
    }

    // Gets maximum reaction time
    public int getMax(int startIndex, int endIndex){
        int maxValue = rtc.getReactionTime(startIndex);
        int currentValue;

        for(int i = startIndex; i <= endIndex; i++) {
            currentValue = rtc.getReactionTime(i);
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }

        return maxValue;
    }

    // Gets average reaction time
    public int getAvg(int startIndex, int endIndex){
        int total = 0;

        for(int i = startIndex; i <= endIndex; i++) {
            total += rtc.getReactionTime(i);
        }

        return (total / numItems);
    }

    // Gets median reaction time
    public double getMed(int startIndex, int endIndex){
        ArrayList<Integer> intList = new ArrayList<Integer>();;

        /* following line retrieved from Richard Tingle, http://stackoverflow.com/questions/
        19090526/dividing-two-integers-to-a-double-in-java, 10/05/15
         */

        double halfNumCountDouble = ((double)numItems / 2);
        int halfNumCountInt;
        double firstNum = 0;
        double secondNum = 0;

        // Populate list
        for(int i = startIndex; i <= endIndex; i++) {
            intList.add(rtc.getReactionTime(i));
        }

        Collections.sort(intList);

        if (numItems == 1) {
            return intList.get(0);
        }else if ( (numItems % 2) == 0 ){
            halfNumCountInt = (int) halfNumCountDouble;
            firstNum = intList.get(halfNumCountInt - 1);
            secondNum = intList.get(halfNumCountInt);
            return ((firstNum + secondNum) / 2);
        } else {
            halfNumCountInt = (int)(halfNumCountDouble - 0.5);
            return intList.get(halfNumCountInt);
        }
    }

    // Generates two player game buzzer stats
    public void twoPlayerGameBuzzes() {
        int playerOneBuzzes = 0;
        int playerTwoBuzzes = 0;

        if (!gsbc.isEmpty(2)) {
            playerOneBuzzes = gsbc.getBuzzes(2, 1);
            playerTwoBuzzes = gsbc.getBuzzes(2, 2);
        }
        statisticsList.add("2 Player Game -> Player 1 Buzzes: " + playerOneBuzzes);
        statisticsList.add("2 Player Game -> Player 2 Buzzes: " + playerTwoBuzzes);
    }

    // Generates three player game buzzer stats
    public void threePlayerGameBuzzes() {
        int playerOneBuzzes = 0;
        int playerTwoBuzzes = 0;
        int playerThreeBuzzes = 0;

        if (!gsbc.isEmpty(3)) {
            playerOneBuzzes = gsbc.getBuzzes(3, 1);
            playerTwoBuzzes = gsbc.getBuzzes(3, 2);
            playerThreeBuzzes = gsbc.getBuzzes(3, 3);
        }
        statisticsList.add("3 Player Game -> Player 1 Buzzes: " + playerOneBuzzes);
        statisticsList.add("3 Player Game -> Player 2 Buzzes: " + playerTwoBuzzes);
        statisticsList.add("3 Player Game -> Player 3 Buzzes: " + playerThreeBuzzes);
    }

    // Generates four player game buzzer stats
    public void fourPlayerGameBuzzes() {
        int playerOneBuzzes = 0;
        int playerTwoBuzzes = 0;
        int playerThreeBuzzes = 0;
        int playerFourBuzzes = 0;

        if (!gsbc.isEmpty(4)) {
            playerOneBuzzes = gsbc.getBuzzes(4, 1);
            playerTwoBuzzes = gsbc.getBuzzes(4, 2);
            playerThreeBuzzes = gsbc.getBuzzes(4, 3);
            playerFourBuzzes = gsbc.getBuzzes(4, 4);
        }
        statisticsList.add("4 Player Game -> Player 1 Buzzes: " + playerOneBuzzes);
        statisticsList.add("4 Player Game -> Player 2 Buzzes: " + playerTwoBuzzes);
        statisticsList.add("4 Player Game -> Player 3 Buzzes: " + playerThreeBuzzes);
        statisticsList.add("4 Player Game -> Player 4 Buzzes: " + playerFourBuzzes);
    }

    public void clearStatistics(){
        statisticsList.clear();
    }

    public String getStat(int index) {
        return statisticsList.get(index);
    }

}
