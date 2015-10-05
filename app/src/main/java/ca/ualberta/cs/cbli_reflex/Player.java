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

/*
 * Created by Carin on 10/4/2015.
 *
 * Class to store Player buzz count information with getter, setter, and remover.
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
