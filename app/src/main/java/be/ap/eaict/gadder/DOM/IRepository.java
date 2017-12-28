package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public interface IRepository {



    //region GETTERS
    List<Event> getEvents();

    List<Event> getEvents(List<Integer> idList);

    List<User> getUsers();

    List<User> getUsers(List<Integer> idList);

    //Places
    List<Place> getPlaces();

    //UsersPerEvent
    List<UsersPerEvent> getUsersPerEvents();

    //FriendsPerUser
    List<FriendsPerUser> getFriendsPerUsers();

    //EventdatePerUser
    List<EventdatePerUser> getEventdatePerUsers();

    //endregion

    //region SETTERS

    void createUser(User user);
    void updateUser(User user);

    void createEvent(Event event);
    void updateEvent(Event event);

    //endregion
}
