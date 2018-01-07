package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class Event {

    private int id;
    private String name;
    private String place;
    private String description;
    private int creator;
    private String eventDate;
    private List<String> datesAvailable;
    private HashMap<String, Invite> invitedUsers;

    public Event(){

    };

    public Event(int id, String name, String place, String description, int creator,
                 String eventDate, List<String> datesAvailable){
        this.id = id;
        this.name = name;
        this.place = place;
        this.description = description;
        this.creator = creator;
        this.eventDate = eventDate;
        this.datesAvailable = datesAvailable;
        this.invitedUsers = new HashMap<>();
        this.invitedUsers.put(Integer.toString(creator), new Invite(creator, InviteState.Accepted, datesAvailable));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getEventDate(){
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public List<String> getDatesAvailable() { return datesAvailable; }

    public void setDatesAvailable(List<String> datesAvailable) { this.datesAvailable = datesAvailable; }

    public HashMap<String, Invite> getInvitedUsers(){
        return invitedUsers;
    }

    public void setInvitedUser(HashMap<String, Invite> invitedUsers) {
        this.invitedUsers = invitedUsers;
    }

    public void addInvitedUser(User user){
        invitedUsers.put(user.getUsername(), new Invite(user.getId(), InviteState.Invited, new ArrayList<String>()));
    }

}
