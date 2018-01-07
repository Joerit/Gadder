package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        GlobalData.currentUser = null;

        setContentView(activity_main);
        FBRepository.getInstance();
    }

    public void onClick(View view){
        //String TAG = "LOGCLICK" ;
        List<User> users = FBRepository.getInstance().getUsers();
        String name = ((EditText)findViewById(R.id.txtUserName)).getText().toString();
        String pass = ((EditText)findViewById(R.id.txtPassword)).getText().toString();
        for(User user : users){
            // find user with correct name
            if (user.getUsername().equals(name)){
                // if pass is correct login is ok
                if(user.getPassword().equals(pass)){
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
