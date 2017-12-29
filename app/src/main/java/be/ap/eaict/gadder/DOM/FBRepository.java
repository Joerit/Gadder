package be.ap.eaict.gadder.DOM;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

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
    private HashMap<Integer, Event> eventCache;
    private HashMap<Integer, User> userCache;


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
                HashMap<Integer, Event> reply = new HashMap<>();
                for (DataSnapshot snap :dataSnapshot.getChildren()){
                    Event event = (Event)snap.getValue();
                    reply.put(event.getId(), event);
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
                HashMap<Integer, User> reply = new HashMap<>();
                for (DataSnapshot snap :dataSnapshot.getChildren()){
                    User user = (User)snap.getValue();
                    reply.put(user.getId(), user);
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

    //
    public void updateEventCache(HashMap<Integer, Event> eList){
        eventCache = eList;
    }

    public void updateUserCache(HashMap<Integer, User> uList) {
        userCache = uList;
    }

}
