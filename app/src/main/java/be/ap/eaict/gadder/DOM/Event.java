package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class Event {

    private int id;
    private String name;
    private String place;
    private String description;
    private int creator;
    private String startDate;
    private String endDate;
    private List<Tuple<Integer, InviteState>> invitedUsers;

    public Event(){

    };

    public Event(int id, String name, String place, String description, int creator,
                 String startDate,String endDate){
        this.id = id;
        this.name = name;
        this.place = place;
        this.description = description;
        this.creator = creator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.invitedUsers = new ArrayList<>();
        this.invitedUsers.add(new Tuple<Integer, InviteState>(creator, InviteState.Accepted));
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

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Tuple<Integer, InviteState>> getInvitedUsers(){
        return invitedUsers;
    }

    public void setInvitedUser(List<Tuple<Integer, InviteState>> invitedUsers) {
        this.invitedUsers = invitedUsers;
    }

    public void addInvitedUser(Tuple<Integer, InviteState> invite){
        invitedUsers.add(invite);
    }

}
