package be.ap.eaict.gadder.DOM;

import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public interface IRepository {

    List<Event> getEvents();
    List<User> getUsers();
}
