package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.User;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ListView eventsList = (ListView) findViewById(R.id.listViewEvents);

        OverviewAdapter overviewAdapter = new OverviewAdapter(this, DummyRepository.getInstance().getEvents(new User(0, "", "", "")));
        eventsList.setAdapter(overviewAdapter);

        final List<Event> values;
        values = DummyRepository.getInstance().getEvents(new User(0, "", "", ""));


        eventsList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        openDetailsActivity(values.get(position));
                    }
                }
        );
    }

    public void onClickCreate(View view){
        openCreateActivity();
    }

    public void onClickFriends(View view){
        OverviewAdapter overviewAdapter = new OverviewAdapter(this, DummyRepository.getInstance().getEvents(new User(0, "", "", "")));
        openFriendsActivity();
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

