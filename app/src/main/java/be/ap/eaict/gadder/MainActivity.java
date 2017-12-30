package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.GlobalData;

import static be.ap.eaict.gadder.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);
        FBRepository.getInstance();

    }

    public void onClick(View view){
        // why is this line here?
        //OverviewAdapter overviewAdapter = new OverviewAdapter(this, FBRepository.getInstance().getEvents());
        openActivity();
    }

    public void openActivity(){
        Intent intent = new Intent(MainActivity.this,  HomeActivity.class);
        ArrayList<Integer> intlist = new ArrayList<>();
        intlist.add(1);
        GlobalData.currentUser = FBRepository.getInstance().getUsers(intlist).get(0);

        startActivity(intent);
        finish();
    }

    public void onClickRegister(View view){
        openRegisterActivity();
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
