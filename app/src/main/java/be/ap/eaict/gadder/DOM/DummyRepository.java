package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;

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

    public List<Event> getEvents(User user){
        List<Event> Events = new ArrayList<>();

        //DUMMY DATA TOEVOEGEN
            Events.add(new Event(0, "Cinema", "Kinepolis", "Film kijken", 1, 2, 3, 2018, 5, 3, 2018 ));
            Events.add(new Event(1, "Schaatsen", "Kerstmarkt", "Op uw gezicht gaan", 1, 2, 4, 2018, 5, 4, 2018 ));

        //


        return Events;
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

    public List<User> getUsers(){
        List<User> Users = new ArrayList<>();

        //DUMMY DATA TOEVOEGEN
        Users.add(new User(0, "Scazi", "kevin-davis@hotmail.com", "kevin123"));
        Users.add(new User(1, "Ratboy", "joeri.temmerman@hotmail.com", "joeri123"));
        Users.add(new User(2, "Beckerich", "ruben.nemes@msn.com", "ruben123"));

        //


        return Users;
    }
}
