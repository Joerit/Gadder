package be.ap.eaict.gadder.DOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class Repository implements IRepository {

    private static IRepository repo = null;

    public static IRepository getInstance() {
        if (repo == null) {
            repo = new Repository();
        }
        return repo;
    }

    public List<Event> getEvents(){
        List<Event> Events = new ArrayList<>();

        //DUMMY DATA TOEVOEGEN

        //


        return Events;
    }
}
