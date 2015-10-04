package ca.ualberta.cs.cbli_reflex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* multiple button handling modified from Rams M, http://ramsandroid4all.blogspot.in/2013/01/
 * working-with-multiple-buttons.html, retrieved 10/04/15
 */

public class FourPlayersActivity extends ActionBarActivity implements View.OnClickListener{

    Button player1Button, player2Button, player3Button, player4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_players);

        player1Button = (Button)findViewById(R.id.oneOfFourPlayersButton);
        player2Button = (Button)findViewById(R.id.twoOfFourPlayersButton);
        player3Button = (Button)findViewById(R.id.threeOfFourPlayersButton);
        player4Button = (Button)findViewById(R.id.fourOfFourPlayersButton);

        player1Button.setOnClickListener(this);
        player2Button.setOnClickListener(this);
        player3Button.setOnClickListener(this);
        player4Button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_players, menu);
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

    @Override
    public void onClick(View v) {
        GameShowBuzzerController gsbc = new GameShowBuzzerController();
        String message = null;

        switch (v.getId()) {
            case R.id.oneOfFourPlayersButton:
                gsbc.addBuzz(4, 1);
                message = "Player 1 clicked first";
                break;
            case R.id.twoOfFourPlayersButton:
                gsbc.addBuzz(4, 2);
                message = "Player 2 clicked first";
                break;
            case R.id.threeOfFourPlayersButton:
                gsbc.addBuzz(4, 3);
                message = "Player 3 clicked first";
                break;
            case R.id.fourOfFourPlayersButton:
                gsbc.addBuzz(4, 4);
                message = "Player 4 clicked first";
                break;
        }

        /* retrieved from Narasimha Battini, http://stackoverflow.com/questions/4204017/how-to-
         * disable-button-click, 10/04/15
         */
        player1Button.setEnabled(false);
        player2Button.setEnabled(false);
        player3Button.setEnabled(false);
        player4Button.setEnabled(false);
        displayMessage(message);

    }

    public void displayMessage(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /* Following line from Sam, http://stackoverflow.com/questions/12150646/prevent-back-button
         *-from-closing-a-dialog-box, 10/04/15
         */
        builder.setCancelable(false);
        builder.setMessage(text);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int BUTTON_POSITIVE) {
                player1Button.setEnabled(true);
                player2Button.setEnabled(true);
                player3Button.setEnabled(true);
                player4Button.setEnabled(true);
            }
        });
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);
        dialog.show();
    }
}
