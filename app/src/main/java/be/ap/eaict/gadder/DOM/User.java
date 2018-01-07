package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private List<Integer> invitedEvents;
    private List<Tuple<Integer, InviteState>> friends;

    public User(){
        this.invitedEvents = new ArrayList<>();
    };

    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.invitedEvents = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getInvitedEvents(){
        return this.invitedEvents;
    }

    public void setInvitedEvents(List<Integer> invitedEvents){
        this.invitedEvents = invitedEvents;
    }

    public void addEvent(Event event){
        this.invitedEvents.add(event.getId());
    }

    public void setFriends(List<Tuple<Integer, InviteState>> friends){
        this.friends = friends;
    }

    public boolean equals(User other){
        return this.id == other.getId();
    }
}
