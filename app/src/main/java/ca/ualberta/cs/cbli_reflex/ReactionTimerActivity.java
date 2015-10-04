package ca.ualberta.cs.cbli_reflex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ReactionTimerActivity extends ActionBarActivity {
    protected long startTime;
    protected long endTime;
    protected boolean goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer_wait);

        goButton = true;
        displayMessage("When you see GO, tap as fast as you can");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reaction_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* Modified from jeevamuthu, http://stackoverflow.com/questions/3965122/android-how-to-
     * align-message-in-alertdialog, 10/02/15
     */
    // Display prompt with message
    public void displayMessage(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(text);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int BUTTON_POSITIVE) {
                beginTest();
            }
        });
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);
        dialog.show();
    }

    /* Retrived from pomber, http://stackoverflow.com/questions/3072173/how-to-call-a-method-
     * after-a-delay-in-android, 10/03/15
     */
    // Random wait time for WAIT button to display GO starts after user dismisses prompt
    // Clicks before GO produce a message to the user and restarts the activity
    public void beginTest(){

        int waitTime = generateRandomWaitTime();

        // Detect early click
        Button waitButton = (Button) findViewById(R.id.reactionTimerWaitButton);
        waitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /* retrieved from Joseph82, http://stackoverflow.com/questions/26168225/disable-
                 * button-after-first-click, 10/04/15
                 */
                v.setEnabled(false);
                goButton = false;

                Toast.makeText(getApplicationContext(), "Don't tap until you see GO",
                        Toast.LENGTH_SHORT).show();

                restartActivity();
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                recordReactionTime();

            }
        }, waitTime);
    }

    /* Retrieved from Vivien Barousse, http://stackoverflow.com/questions/6029495/how-can-i-
       generate-random-number-in-specific-range-in-android, 10/03/15
     */
    // Generates random wait time between 10-2000 ms
    public int generateRandomWaitTime() {
        int min = 10;
        int max = 2000;

        Random r = new Random();

        return r.nextInt(max - min + 1) + min;
    }

    // ReactionTimerController adds reaction time to persistent ReactionTimeList
    // User is shown their reaction time list before activity is restarted
    public void recordReactionTime(){
        startTime = (System.nanoTime() / Math.round(Math.pow(10, 6)));

        // Button only displays "GO" if goButton flag is true
        if (goButton) {
            Button waitButton = (Button) findViewById(R.id.reactionTimerWaitButton);
            waitButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    v.setEnabled(false);
                    endTime = (System.nanoTime() / Math.round(Math.pow(10, 6)));
                    int reactionTime = (int) (endTime - startTime);

                    ReactionTimerController rtc = new ReactionTimerController();
                    rtc.addReactionTime(reactionTime);

                /* Modified from Pushp Raj Saurabh, http://stackoverflow.com/questions/17716813/
                cannot-resolve-maketext-method-of-toast, 10/04/15
                 */
                    Toast.makeText(getApplicationContext(), "Reaction time: " + reactionTime + " ms",
                            Toast.LENGTH_SHORT).show();

                    restartActivity();
                }
            });

            waitButton.setText("GO");
        }

    }

    // restarts activity after a 1 s delay
    public void restartActivity() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        }, 1000);
    }

}
