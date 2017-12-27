package be.ap.eaict.gadder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView txtLoginLink = (TextView) findViewById(R.id.txtLoginLink);
        txtLoginLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
