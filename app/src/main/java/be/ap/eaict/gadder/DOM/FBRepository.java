package be.ap.eaict.gadder.DOM;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by joeri on 28/12/2017.
 */

public class FBRepository implements IRepository {
    private static FBRepository repo = null;
    private List<Event> eventCache;
    private List<User> userCache;


    public static FBRepository getInstance() {
        if (repo == null) {
            repo = new FBRepository();
        }
        return repo;
    }

    public FBRepository(){
        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();

        DatabaseReference eventRef = fbdb.getReference("events");
        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Event> reply = new ArrayList<>();
                for (DataSnapshot event :dataSnapshot.getChildren()){
                    reply.add(event.getValue(Event.class));
                }
                FBRepository.getInstance().updateEventCache(reply);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference userRef = fbdb.getReference("users");
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> reply = new ArrayList<>();
                for (DataSnapshot user :dataSnapshot.getChildren()){
                    reply.add(user.getValue(User.class));
                }
                FBRepository.getInstance().updateUserCache(reply);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    @Override
    public List<Event> getEvents(){
        return eventCache;
    }

    @Override
    public List<Event> getEvents(List<Integer> idList) {
        ArrayList<Event> retList = new ArrayList<>();
        for(Event event: eventCache){
            if(idList.contains(event.getId())){
                retList.add(event);
            }
        }
        return retList;
    }

    @Override
    public List<User> getUsers() {
        return userCache;
    }

    @Override
    public List<User> getUsers(List<Integer> idList) {
        ArrayList<User> retList = new ArrayList<>();
        for(User user: userCache){
            if(idList.contains(user.getId())){
                retList.add(user);
            }
        }
        return retList;
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

    //
    public void updateEventCache(List<Event> eList){
        eventCache = eList;
    }

    public void updateUserCache(List<User> uList) {
        userCache = uList;
    }

}
