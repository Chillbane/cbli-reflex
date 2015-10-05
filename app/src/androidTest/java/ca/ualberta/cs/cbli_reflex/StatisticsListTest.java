package ca.ualberta.cs.cbli_reflex;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/*
 * Created by Carin on 10/4/2015.
 */
public class StatisticsListTest extends ActivityInstrumentationTestCase2 {

    public StatisticsListTest(){
        super(ca.ualberta.cs.cbli_reflex.GameShowBuzzerControllerTest.class);
    }

    public void testAddToStatsList() throws Exception {
        ReactionTimerController rtc = new ReactionTimerController();
        rtc.addReactionTime(50);
        StatisticsList statsList = new StatisticsList();
        System.out.println("Index: " + statsList.getStat(0));
    }
}