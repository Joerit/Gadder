package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.ap.eaict.gadder.Adapters.OverviewAdapter;
import be.ap.eaict.gadder.DOM.DummyRepository;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.GlobalData;
import be.ap.eaict.gadder.DOM.User;

import static be.ap.eaict.gadder.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);
        FBRepository.getInstance();
    }

    public void onClick(View view){
        List<User> users = FBRepository.getInstance().getUsers();
        for(User user : users){
            // find user with correct name
            if (user.getUsername().equals(findViewById(R.id.txtUserName))){
                // if pass is correct login is ok
                if(user.getPassword().equals(findViewById(R.id.txtPassword))){
                    GlobalData.currentUser = user;
                }
                break;
            }
        }
        if(GlobalData.currentUser == null){
            Toast.makeText(this, "invalid login", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this,  HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onClickRegister(View view){
        openRegisterActivity();
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
