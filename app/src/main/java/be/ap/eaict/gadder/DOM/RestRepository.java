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
    String serverUrl;

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
        URL serveradress;
        List<Event> ret = new ArrayList<Event>();
        try {
            serveradress = new URL( serverUrl + "getEvents.php");

            HttpURLConnection c = (HttpURLConnection) serveradress.openConnection();

            if(c.getResponseCode() == 200){
                JSONArray JsArr = new JSONArray(new InputStreamReader(c.getInputStream(), "UTF-8"));
                for (int i = 0; i < JsArr.length(); i++){
                    ret.add(new Event(JsArr.getJSONObject(i)));
                }
                return ret;
            }
            else{
                //panick
            }
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
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
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
