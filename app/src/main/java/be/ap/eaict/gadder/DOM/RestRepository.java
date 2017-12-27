package be.ap.eaict.gadder.DOM;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joeri on 22/12/2017.
 */

public class RestRepository implements IRepository {
    private RestRepository repo;
    private String serverUrl;

    private class getEventsTask extends AsyncTask<Integer, Void, Void>{
        boolean done;
        List<Event> reply;
        @Override
        protected Void doInBackground(Integer... inputs) {
            done = false;
            List<Event> reply = new ArrayList<Event>();
            try {
                URL serveradress = new URL( serverUrl + "getEvents.php");

                HttpURLConnection c = (HttpURLConnection) serveradress.openConnection();

                if(c.getResponseCode() == 200){
                    JSONArray JsArr = new JSONArray(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    for (int i = 0; i < JsArr.length(); i++) {
                        reply.add(new Event(JsArr.getJSONObject(i)));
                    }
                    done = true;
                    return null;
                }
                else{
                    //panick
                }
                done = true;
                return null;
            }
            catch (MalformedURLException e){
                throw new RuntimeException("the internet is broken");
            }
            catch (IOException e){
                // do absolutely nothing
            }
            catch (JSONException e){
                // think of the children
            }
            done = true;
            return null;
        }
    }

    private class getUsersTask extends AsyncTask<Integer, Void, Void>{
        boolean done;
        List<User> reply;
        @Override
        protected Void doInBackground(Integer... inputs) {
            done = false;
            List<User> reply = new ArrayList<User>();
            try {
                URL serveradress = new URL( serverUrl + "getUsers.php");

                HttpURLConnection c = (HttpURLConnection) serveradress.openConnection();

                if(c.getResponseCode() == 200){
                    JSONArray JsArr = new JSONArray(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    for (int i = 0; i < JsArr.length(); i++) {
                        reply.add(new User(JsArr.getJSONObject(i)));
                    }
                    done = true;
                    return null;
                }
                else{
                    //panick
                }
                done = true;
                return null;
            }
            catch (MalformedURLException e){
                throw new RuntimeException("the internet is broken");
            }
            catch (IOException e){
                // do absolutely nothing
            }
            catch (JSONException e){
                // think of the children
            }
            done = true;
            return null;
        }
    }

    RestRepository(){
        serverUrl = "http://brabo.ddns.net:2102/gadderapi/";
    }

    @Override
    public IRepository getInstance() {
        if (repo == null) {
            repo = new RestRepository();
        }
        return repo;
    }

    @Override
    public List<Event> getEvents() {
        getEventsTask task = new getEventsTask();
        task.execute(1);
        while (!task.done){
            // wait?
            // show "loading"?
        }
        return task.reply;
    }

    @Override
    public List<User> getUsers() {
        getUsersTask task = new getUsersTask();
        task.execute(1);
        while (!task.done){
            // wait?
            // show "loading"?
        }
        return task.reply;
    }

    @Override
    public List<Place> getPlaces() {
        return null;
    }

    @Override
    public List<UsersPerEvent> getUsersPerEvents() {
        return null;
    }

    @Override
    public List<FriendsPerUser> getFriendsPerUsers() {
        return null;
    }

    @Override
    public List<EventdatePerUser> getEventdatePerUsers() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void createEvent(Event event) {

    }

    @Override
    public void updateEvent(Event event) {

    }
}
