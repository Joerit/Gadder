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

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ListView eventsList = (ListView) findViewById(R.id.listViewEvents);

        OverviewAdapter overviewAdapter = new OverviewAdapter(this, DummyRepository.getInstance().getEvents());
        eventsList.setAdapter(overviewAdapter);

        final List<Event> values;
        values = DummyRepository.getInstance().getEvents();


        eventsList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        openDetailsActivity(values.get(position));
                    }
                }
        );
    }

    public void onClickFriends(View view){
        OverviewAdapter overviewAdapter = new OverviewAdapter(this, DummyRepository.getInstance().getEvents());
        openFriendsActivity();
    }

    public void openDetailsActivity(Event event) {
        Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }

    public void openFriendsActivity() {
        Intent intent = new Intent(HomeActivity.this, FriendslistActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }
}

