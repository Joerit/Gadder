package be.ap.eaict.gadder.DOM;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by joeri on 28/12/2017.
 */

public class FBRepository implements IRepository {
    private static FBRepository repo = null;
    protected HashMap<Integer, Event> eventCache;
    protected HashMap<Integer, User> userCache;


    public static FBRepository getInstance() {
        if (repo == null) {
            repo = new FBRepository();
        }
        return repo;
    }

    public FBRepository(){
        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();

        DatabaseReference eventRef = fbdb.getReference("events");
        eventRef.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevName) {
                FBRepository.getInstance().eventCache.put(
                        Integer.getInteger(dataSnapshot.getKey()),
                        dataSnapshot.getValue(Event.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot){
                FBRepository.getInstance().eventCache.remove(dataSnapshot.getKey());
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String prevName){
                FBRepository.getInstance().eventCache.put(
                        Integer.getInteger(dataSnapshot.getKey()),
                        dataSnapshot.getValue(Event.class));
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String prevName){

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference userRef = fbdb.getReference("users");

        userRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevName) {
                FBRepository.getInstance().userCache.put(
                        Integer.getInteger(dataSnapshot.getKey()),
                        dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                FBRepository.getInstance().userCache.remove(dataSnapshot.getKey());
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String prevName) {
                FBRepository.getInstance().userCache.put(
                        Integer.getInteger(dataSnapshot.getKey()),
                        dataSnapshot.getValue(User.class));
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String prevName) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public List<Event> getEvents(){
        return new ArrayList<>(eventCache.values());
    }

    @Override
    public List<Event> getEvents(List<Integer> idList) {
        ArrayList<Event> retList = new ArrayList<>();
        for(Integer id: idList){
            retList.add(eventCache.get(id));
        }
        return retList;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userCache.values());
    }

    @Override
    public List<User> getUsers(List<Integer> idList) {
        ArrayList<User> retList = new ArrayList<>();
        for(Integer id: idList){
            retList.add(userCache.get(id));
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
        createOrUpdateUser(user);
    }

    @Override
    public void updateUser(User user) {
        createOrUpdateUser(user);
    }

    @Override
    public void createOrUpdateUser(User user) {
        if(user.getId() == -1){
            user.setId(userCache.size());
            userCache.put(user.getId(), user);
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("events");
        ref.child(Integer.toString(user.getId())).setValue(user);
    }

    @Override
    public void createEvent(Event event) {
        createOrUpdateEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        createOrUpdateEvent(event);
    }

    @Override
    public void createOrUpdateEvent(Event event) {
        if(event.getId() == -1){
            event.setId(eventCache.size());
            eventCache.put(event.getId(), event);
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("events");
        ref.child(Integer.toString(event.getId())).setValue(event);
    }

}
