package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class DummyRepository implements IRepository {

    private static IRepository repo = null;

    public static IRepository getInstance() {
        if (repo == null) {
            repo = new DummyRepository();
        }
        return repo;
    }


    //region GETTERS
    public List<Event> getEvents(){
        List<Event> events = new ArrayList<>();

        //Events
        events.add(new Event(0, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(1, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(2, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(3, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(4, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(5, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(6, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(7, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(8, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(9, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(10, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(11, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));
        events.add(new Event(12, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
        events.add(new Event(13, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));


        return events;
    }

    @Override
    public List<Event> getEvents(List<Integer> idList) {
        return null;
    }


    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        //Users
        users.add(new User(0, "Scazi", "kevin-davis@hotmail.com", "kevin123"));
        users.add(new User(1, "Ratboy", "joeri.temmerman@hotmail.com", "joeri123"));
        users.add(new User(2, "Beckerich", "ruben.nemes@msn.com", "ruben123"));

        return users;
    }

    @Override
    public List<User> getUsers(List<Integer> idList) {
        return null;
    }

    //Places
    public List<Place> getPlaces(){
        List<Place> places = new ArrayList<>();

        return places;
    }

    //UsersPerEvent
    public List<UsersPerEvent> getUsersPerEvents(){
        List<UsersPerEvent> usersPerEvents = new ArrayList<>();

        return usersPerEvents;
    }

    //FriendsPerUser
    public List<FriendsPerUser> getFriendsPerUsers(){
        List<FriendsPerUser> friendsPerUsers = new ArrayList<>();

        return friendsPerUsers;
    }

    //EventdatePerUser
    public List<EventdatePerUser> getEventdatePerUsers(){
        List<EventdatePerUser> eventdatePerUsers = new ArrayList<>();

        return eventdatePerUsers;
    }

    //endregion

    //region SETTERS

    @Override
    public void createUser(User user){

    }

    @Override
    public void updateUser(User user){

    }

    @Override
    public void updateEvent(Event event){

    }
    @Override
    public void createEvent(Event event) {

    }



    //endregion
}
