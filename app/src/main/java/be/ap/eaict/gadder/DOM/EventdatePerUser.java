package be.ap.eaict.gadder.DOM;

import java.util.Calendar;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class EventdatePerUser {

    private int userID;
    private int eventID;
    private Calendar date;
    private boolean status;


    public EventdatePerUser(int userID, int eventID, Calendar date, boolean status){
        this.userID = userID;
        this.eventID = eventID;
        this.date = date;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
