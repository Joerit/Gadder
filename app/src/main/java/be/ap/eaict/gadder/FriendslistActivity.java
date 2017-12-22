package be.ap.eaict.gadder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import be.ap.eaict.gadder.Adapters.FriendslistAdapter;
import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;

public class FriendslistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendslist);


        final ListView friendsList = (ListView) findViewById(R.id.ListviewFriends);

        FriendslistAdapter FriendlistAdapter = new FriendslistAdapter(this, DummyRepository.getInstance().getUsers());
        friendsList.setAdapter(FriendlistAdapter);
    }
}
