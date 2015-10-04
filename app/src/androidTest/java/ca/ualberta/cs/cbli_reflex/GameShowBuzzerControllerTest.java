package ca.ualberta.cs.cbli_reflex;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/*
 * Created by Carin on 10/4/2015.
 */
public class GameShowBuzzerControllerTest extends android.test.ActivityInstrumentationTestCase2 {

    public GameShowBuzzerControllerTest(){
        super(ca.ualberta.cs.cbli_reflex.GameShowBuzzerControllerTest.class);
    }

    public void testGetTwoPlayerGame() throws Exception {
        GameShowBuzzerController gsbc = new GameShowBuzzerController();
        gsbc.addBuzz(2, 1);
        gsbc.addBuzz(2, 2);
        gsbc.addBuzz(2, 1);
        assertTrue(gsbc.getBuzzes(2, 1) == 2);
    }


}