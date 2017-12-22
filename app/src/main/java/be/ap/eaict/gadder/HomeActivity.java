package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.Event;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ListView eventsList = (ListView) findViewById(R.id.listViewEvents);

        MyAdapter myAdapter = new MyAdapter(this, DummyRepository.getInstance().getEvents());
        eventsList.setAdapter(myAdapter);

        final ListView listViewEvents = (ListView) findViewById(R.id.listViewEvents);

        final List<Event> values;
        values = DummyRepository.getInstance().getEvents();

        listViewEvents.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        openActivity(values.get(position));
                    }
                }
        );
    }

    public void openActivity(Event event) {
        Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }
}

