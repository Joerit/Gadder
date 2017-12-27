package be.ap.eaict.gadder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void onClickEdit(View view){
        openEditActivity();
    }

    public void openEditActivity(){
        Intent intent = new Intent(DetailsActivity.this, EditActivity.class);

        //INPUT DATA

        //

        startActivity(intent);
    }
}
