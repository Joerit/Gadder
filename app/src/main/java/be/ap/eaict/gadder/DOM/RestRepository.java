package be.ap.eaict.gadder.DOM;

import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by joeri on 22/12/2017.
 */

public class RestRepository implements IRepository {
    private URL serveraddress;

    RestRepository(){
        String serverurl = "http://brabo.ddns.net:2102/gadderapi/";
    }

    @Override
    public List<Event> getEvents(User user) {
        try {
            serveraddress = new URL( serveraddress + "");
        }
        catch (MalformedURLException e){
            throw new RuntimeException("the internet is broken");
        }

        return null;
    }

    @Override
    public boolean addEvent(Event event) {
        return false;
    }

    @Override
    public List<User> getFriends(User user) {
        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        return null;
    }

    @Override
    public boolean addFriend(User user1, User user2) {
        return false;
    }

    @Override
    public List<Event> getInvitations(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
