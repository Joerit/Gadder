package be.ap.eaict.gadder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import be.ap.eaict.gadder.R;

import be.ap.eaict.gadder.DOM.Repository;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ListView eventsList = (ListView) findViewById(R.id.listViewEvents);

        MyAdapter myAdapter = new MyAdapter(this, Repository.getInstance().getEvents());
        eventsList.setAdapter(myAdapter);
    }
}
