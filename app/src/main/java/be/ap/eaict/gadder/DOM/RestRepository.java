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
        try {
            serveraddress = new URL("http://brabo.ddns.net/");
        }
        catch (MalformedURLException e){
            throw new RuntimeException("the internet is broken");
        }
    }

    @Override
    public List<Event> getEvents(User user) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                // All your networking logic
                // should be here
            }
        });

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
}
