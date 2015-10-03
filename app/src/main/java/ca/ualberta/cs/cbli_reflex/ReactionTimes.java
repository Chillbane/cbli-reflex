package ca.ualberta.cs.cbli_reflex;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Carin on 10/2/2015.
 */
public class ReactionTimes {

    private int reactionTime;
    protected List<Integer> reactionTimesList = new ArrayList<Integer>();

    public void addReactionTime(int reactionTime) {
        reactionTimesList.add(reactionTime);
    }

    public int totalTimes() {
        return reactionTimesList.size();
    }

    public void clearReactionTimes(){
        reactionTimesList.clear();
    }

}
