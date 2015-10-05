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

// This class handles the "How Many Players?" view for the user to choose a game buzzer format
package ca.ualberta.cs.cbli_reflex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GameShowBuzzerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_many_players);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_how_many_players, menu);
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

    /* Called when the user clicks the Two Players button */
    public void openTwoPlayers(View view) {
        Intent intent = new Intent(this, TwoPlayersActivity.class);
        startActivity(intent);
    }

    /* Called when the user clicks the Three Players button */
    public void openThreePlayers(View view) {
        Intent intent = new Intent(this, ThreePlayersActivity.class);
        startActivity(intent);
    }

    /* Called when the user clicks the Two Players button */
    public void openFourPlayers(View view) {
        Intent intent = new Intent(this, FourPlayersActivity.class);
        startActivity(intent);
    }
}
