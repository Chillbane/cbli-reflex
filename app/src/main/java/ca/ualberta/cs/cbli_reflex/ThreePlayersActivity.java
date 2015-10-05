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

// This class handles a three player buzzer game. Buzzes are stored with GameShowBuzzerController.

/* multiple button handling modified from Rams M, http://ramsandroid4all.blogspot.in/2013/01/
 * working-with-multiple-buttons.html, retrieved 10/04/15
 */

public class ThreePlayersActivity extends ActionBarActivity implements View.OnClickListener{

    Button player1Button, player2Button, player3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_players);

        player1Button = (Button)findViewById(R.id.oneOfThreePlayersButton);
        player2Button = (Button)findViewById(R.id.twoOfThreePlayersButton);
        player3Button = (Button)findViewById(R.id.threeOfThreePlayersButton);

        player1Button.setOnClickListener(this);
        player2Button.setOnClickListener(this);
        player3Button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_players, menu);
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
            case R.id.oneOfThreePlayersButton:
                gsbc.addBuzz(3, 1);
                message = "Player 1 clicked first";
                break;
            case R.id.twoOfThreePlayersButton:
                gsbc.addBuzz(3, 2);
                message = "Player 2 clicked first";
                break;
            case R.id.threeOfThreePlayersButton:
                gsbc.addBuzz(3, 3);
                message = "Player 3 clicked first";
                break;
        }

        /* retrieved from Narasimha Battini, http://stackoverflow.com/questions/4204017/how-to-
         * disable-button-click, 10/04/15
         */
        player1Button.setEnabled(false);
        player2Button.setEnabled(false);
        player3Button.setEnabled(false);
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
            }
        });
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);
        dialog.show();
    }
}
