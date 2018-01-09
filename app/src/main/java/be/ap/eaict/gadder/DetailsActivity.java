package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import be.ap.eaict.gadder.Adapters.InvitationAdapter;
import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;

public class DetailsActivity extends AppCompatActivity
        implements OnMapReadyCallback{
    Event event;
    private int _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        _id = (int)getIntent().getExtras().get("id");
        event = FBRepository.getInstance().getEvent(_id);
        Log.d("DETAILS", "onCreate: "+event.toString());
        TextView txtName = (TextView)findViewById(R.id.txtName);
        TextView txtCreator = (TextView)findViewById(R.id.txtCreator);

        txtName.setText(event.getName());
        txtCreator.setText("Created by " +  FBRepository.getInstance().getUser(event.getCreator()).getUsername());


        //GOOGLE MAPS
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng APhogeschool = new LatLng(51.2300581, 4.4160022);
        googleMap.addMarker(new MarkerOptions().position(APhogeschool) // ADDING MARKER
                .title("Marker on AP"));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(16));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(APhogeschool));
    }


    public void onResume(){
        super.onResume();
        final ListView friendInviteList = (ListView) findViewById(R.id.inviteFriendsInEventList);

        InvitationAdapter invitationAdapter = new InvitationAdapter(this, FBRepository.getInstance().getUsers(), event);
        friendInviteList.setAdapter(invitationAdapter);
    }



    public void onClickEdit(View view){
        openEditActivity();
    }

    public void openEditActivity(){
        Intent intent = new Intent(DetailsActivity.this, EditActivity.class);
        intent.putExtra("eventId", event.getId());
        startActivity(intent);
    }

    public void onClickDateAvailableList(View view){
        Intent intent = new Intent(DetailsActivity.this, DateSelectActivity.class);
        intent.putExtra("eventId", event.getId());
        startActivity(intent);
    }
    
    public void onClickDeleteEvent(View view){

    }
}
