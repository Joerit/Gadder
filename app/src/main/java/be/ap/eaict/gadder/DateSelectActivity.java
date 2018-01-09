package be.ap.eaict.gadder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.ap.eaict.gadder.Adapters.DatesAdapter;
import be.ap.eaict.gadder.DOM.Datum;
import be.ap.eaict.gadder.DOM.FBRepository;

/**
 * Created by Ruben on 28-12-2017.
 */



public class DateSelectActivity extends AppCompatActivity {
    private int _id;
    private Datum datum = new Datum();

    private static final String TAG = "DateSelectActivity";

    FBRepository data = new FBRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateselect);

        _id = (int)getIntent().getExtras().get("eventId");
        final ListView dates = (ListView) findViewById(R.id.listDates);
        final Button btnSave = (Button) findViewById(R.id.btnSave);
        final DatesAdapter adapter = new DatesAdapter(this, FBRepository.getInstance().getDatesAvailableById(_id));

        dates.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> temp = datum.bubbleSort((ArrayList<String>) adapter.getDatesSelected());
                Log.d("checkboxchanged", temp.toString());
            }
        });

    }
}
