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

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/* This class handles the Statistics Activity which displays a list view to the user of all the
 * stats.  In the Action Bar, there are two buttons: Delete All (clear all stats) and Email.
 */
public class StatisticsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        StatisticsList statsList = new StatisticsList();

        ListView listView = (ListView) findViewById(R.id.statisticsListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, statsList.getStatistics());
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics, menu);
        return true;
    }

    /* retrieved from Payload Media, http://www.techotopia.com/index.php/
     * Creating_and_Managing_Overflow_Menus_in_Android_Studio, 10/05/15
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            /* Called when the user clicks the Delete All button */
            case R.id.action_settings:
                ReactionTimerController rtc = new ReactionTimerController();
                GameShowBuzzerController gsbc = new GameShowBuzzerController();

                rtc.clearReactionTimes();
                gsbc.clearBuzzes();

                recreate();
                return true;

            /* Called when the user clicks the Email button */
            case R.id.email_setting:
                StatisticsList statsList = new StatisticsList();
                String data = "STATS \n";
                for(int i = 0; i < 21; i++) {
                    data += (statsList.getStat(i) + "\n");
                }
                sendEmail("Stats", data);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* retrieved from Android Open Source Project, https://developer.android.com/guide/components/
     * intents-common.html#Email, 05/10/15
     */
    // Handles emailing stats
    public void sendEmail(String subject, String attachment) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
