package be.ap.eaict.gadder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import be.ap.eaict.gadder.Adapters.DatesAdapter;
import be.ap.eaict.gadder.DOM.FBRepository;

/**
 * Created by Ruben on 28-12-2017.
 */



public class DateSelectActivity extends AppCompatActivity {
    private int _id;

    private static final String TAG = "DateSelectActivity";

    FBRepository data = new FBRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateselect);

        _id = (int)getIntent().getExtras().get("eventId");
        final ListView dates = (ListView) findViewById(R.id.listDates);
        final DatesAdapter adapter = new DatesAdapter(this, FBRepository.getInstance().getDatesAvailableById(_id));

        dates.setAdapter(adapter);
    }
}
