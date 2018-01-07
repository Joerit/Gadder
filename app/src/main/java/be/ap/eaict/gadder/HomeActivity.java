package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Calendar;
import java.util.List;

import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.GlobalData;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        Log.d("", "onCreate: globaluser=" + GlobalData.currentUser.getUsername());
        super.onResume();
        setContentView(R.layout.activity_home);

        final ListView eventsList = (ListView) findViewById(R.id.listViewEvents);

        OverviewAdapter overviewAdapter = new OverviewAdapter(this, FBRepository.getInstance().getEventsByUser(GlobalData.currentUser));
        eventsList.setAdapter(overviewAdapter);

        final List<Event> values;
        values = FBRepository.getInstance().getEvents();

        eventsList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        openDetailsActivity(values.get(position));
                    }
                }
        );
    }

    /*public Event getNextEvent(List<Event> values){
        Calendar today = Calendar.getInstance();
        Calendar crntApp = Calendar.getInstance();
        Calendar nxtApp = Calendar.getInstance();

        Event nextEvent = values.get(0);
        for (Event event: values) {

            String date = event.getEventDate();




            crntApp.set(event.getYear(), event.getMonth(),
                    event.getDay(), event.getHour(),
                    event.getMinute());
            nxtApp.set(nexteEvent.getYear(),nextEvent.getMonth(),
                    nextEvent.getDay(), nextEvent.getHour(),
                    nextEvent.getMinute());
            if(crntApp.compareTo(today) > 0){
                if(crntApp.compareTo(nxtApp) < 0){
                    nextEvent = event;
                }
            }
        }

        return nextEvent;
    }
*/
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onClickCreate(View view){
        openCreateActivity();
    }

    public void onClickFriends(View view){
        OverviewAdapter overviewAdapter = new OverviewAdapter(this, FBRepository.getInstance().getEvents());
        openFriendsActivity();
    }

    public void onClickLogout(View view){
        logout();
    }

    public void logout(){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
        finish();
    }

    public void openCreateActivity(){
        Intent intent = new Intent(HomeActivity.this, CreateActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }

    public void openDetailsActivity(Event event) {
        Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }

    public void openFriendsActivity() {
        Intent intent = new Intent(HomeActivity.this, FriendlistActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }
}

