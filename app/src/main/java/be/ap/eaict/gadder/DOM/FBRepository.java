package be.ap.eaict.gadder.DOM;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;

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
    protected Integer nextEventId;
    protected HashMap<Integer, User> userCache;
    protected Integer nextUserId;


    public static FBRepository getInstance() {
        if (repo == null) {
            repo = new FBRepository();
        }
        return repo;
    }

    public FBRepository(){
        eventCache = new HashMap<>();
        userCache = new HashMap<>();
        nextEventId = 0;
        nextUserId = 0;

        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();

        // fill eventCache /////
        final DatabaseReference eventRef = fbdb.getReference("events");
        eventRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("FBREPO", "adding elements");
                for(DataSnapshot snap: dataSnapshot.getChildren()){
                    eventCache.put(Integer.valueOf(snap.getKey()), snap.getValue(Event.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // add listener to update eventCache on change
        eventRef.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevName) {
                Log.d("FBREP", "in onChildAdded");
                Integer id = Integer.valueOf(dataSnapshot.getKey());
                FBRepository.getInstance().eventCache.put(
                        id,
                        dataSnapshot.getValue(Event.class));
                if(id >= nextEventId){
                    nextEventId = id+1;
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot){
                FBRepository.getInstance().eventCache.remove(Integer.valueOf(dataSnapshot.getKey()));
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String prevName){
                FBRepository.getInstance().eventCache.put(
                        Integer.valueOf(dataSnapshot.getKey()),
                        dataSnapshot.getValue(Event.class));
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String prevName){

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // fill usercache
        DatabaseReference userRef = fbdb.getReference("users");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snap: dataSnapshot.getChildren()){
                    userCache.put(Integer.valueOf(snap.getKey()), snap.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // add listener to update usercache on change
        userRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevName) {
                FBRepository.getInstance().userCache.put(
                        Integer.valueOf(dataSnapshot.getKey()),
                        dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                FBRepository.getInstance().userCache.remove(Integer.valueOf(dataSnapshot.getKey()));
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String prevName) {
                FBRepository.getInstance().userCache.put(
                        Integer.valueOf(dataSnapshot.getKey()),
                        dataSnapshot.getValue(User.class));
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String prevName) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    // get all events
    @Override
    public List<Event> getEvents(){
        return new ArrayList<>(eventCache.values());
    }

    // get datesavailable by event ID
    @Override
    public List<String> getDatesAvailableById(int id) {
        return eventCache.get(id).getDatesAvailable();
    }

    // get events by ID
    @Override
    public List<Event> getEvents(List<Integer> idList) {
        ArrayList<Event> retList = new ArrayList<>();
        for(Integer id: idList){
            retList.add(eventCache.get(id));
        }
        return retList;
    }

    // get events concerning specific user
    public List<Event> getEventsByUser(User user) {
        user = getUser(user.getId());   // make sure refference is up to date
        return getEvents(user.getInvitedEvents());
    }

    // get single user
    public User getUser(Integer userId) {
        return userCache.get(userId);
    }
    // get all users
    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userCache.values());
    }

    // get users by ID
    @Override
    public List<User> getUsers(List<Integer> idList) {
        ArrayList<User> retList = new ArrayList<>();
        for(Integer id: idList){
            retList.add(userCache.get(id));
        }
        return retList;
    }

    // not implemented yet
    @Override
    public List<Place> getPlaces() {
        return null;
    }

    // not going to be used i think, event has list of IDs
    @Override
    public List<UsersPerEvent> getUsersPerEvents() {
        return null;
    }

    // not going to be used i think, user has list of IDs
    @Override
    public List<FriendsPerUser> getFriendsPerUsers() {
        return null;
    }

    // not implemented yet
    @Override
    public List<EventdatePerUser> getEventdatePerUsers() {
        return null;
    }

    //just use createorupdate instead
    @Override
    public void createUser(User user) {
        createOrUpdateUser(user);
    }

    //just use createorupdate instead
    @Override
    public void updateUser(User user) {
        createOrUpdateUser(user);
    }

    // insert new user or update existing user
    @Override
    public void createOrUpdateUser(User user) {
        if(user.getId() == -1){
            user.setId(nextUserId);
            nextUserId++;
            userCache.put(user.getId(), user);
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("events");
        ref.child(Integer.toString(user.getId())).setValue(user);
    }

    //just use createorupdate instead
    @Override
    public void createEvent(Event event) {
        createOrUpdateEvent(event);
    }

    //just use createorupdate instead
    @Override
    public void updateEvent(Event event) {
        createOrUpdateEvent(event);
    }

    // insert new event or update existing event
    @Override
    public void createOrUpdateEvent(Event event) {
        if(event.getId() == -1){
            event.setId(nextEventId);
            nextEventId++;
            eventCache.put(event.getId(), event);
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("events");
        ref.child(Integer.toString(event.getId())).setValue(event);
    }

}
