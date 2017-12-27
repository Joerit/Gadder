package be.ap.eaict.gadder.DOM;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class User {

    private int id;
    private String username;
    private String email;
    private String password;


    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(JSONObject JsObj){
        try {
            this.id = JsObj.getInt("id");
            this.username = JsObj.getString("name");
            this.email = JsObj.getString("email");
            this.password = JsObj.getString("pass");
        }
        catch(JSONException e){
            Log.e("USER", "JSONEXCEPTION");
        }
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
