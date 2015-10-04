package ca.ualberta.cs.cbli_reflex;

/*
 * Created by Carin on 10/4/2015.
 */
public class Player {
    private int buzzCount = 0;

    public void increaseBuzzerCount() {
       buzzCount += 1;
    }

    public int getBuzzerCount() {
        return buzzCount;
    }

    public void clearBuzzerCount () {
        buzzCount = 0;
    }
}
