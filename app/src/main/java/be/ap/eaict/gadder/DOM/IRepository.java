package be.ap.eaict.gadder.DOM;

import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public interface IRepository {

    // return all events of  user
    List<Event> getEvents(User user);
    // push created event to the server, returns true = success, false = failure
    boolean addEvent(Event event);

    // returns all friends of user
    List<User> getFriends(User user);
    // returns list of all users who match name
    List<User> findUserByName(String name);
    // push friendship between users to server
    boolean addFriend(User user1, User user2);

    // returns all events with open invitation for user
    List<Event> getInvitations(User user);
    
    // return all users (do we need this?)
    List<User> getUsers();
}
