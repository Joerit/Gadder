package be.ap.eaict.gadder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.User;

public class RegisterActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView txtLoginLink = (TextView) findViewById(R.id.txtLoginLink);
        txtLoginLink.setMovementMethod(LinkMovementMethod.getInstance());

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
                EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
                EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
                EditText txtRepeatPassword = (EditText)findViewById(R.id.txtRepeatPassword);

                String userName = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                String repeatPass = txtRepeatPassword.getText().toString();

                if(userName.equals("") || email.equals("") || pass.equals("") || repeatPass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!pass.equals(repeatPass)){
                    Toast.makeText(RegisterActivity.this, "please retype paswords", Toast.LENGTH_SHORT).show();
                }
                else{
                    User newUser = new User(-1, userName, email, pass);
                    FBRepository.getInstance().createUser(newUser);
                }
            }
        });
    }
}
