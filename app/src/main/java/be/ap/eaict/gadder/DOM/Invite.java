package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joeri on 7/01/2018.
 */

public class Invite {
    public int userId;
    public InviteState state;
    public List<String> dates;

    public Invite(){
    }

    public Invite(int userId, InviteState state, List<String> dates) {
        this.userId = userId;
        this.state = state;
        this.dates = dates;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public InviteState getState() {
        return state;
    }

    public void setState(InviteState state) {
        this.state = state;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
}
