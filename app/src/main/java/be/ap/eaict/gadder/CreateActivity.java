package be.ap.eaict.gadder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.GlobalData;
import be.ap.eaict.gadder.DOM.InviteState;
import be.ap.eaict.gadder.DOM.Tuple;

public class CreateActivity extends AppCompatActivity {

    private EditText eventDate;
    private DatePickerDialog.OnDateSetListener eventDateListener;
    private Button btnCreate;
    private Button btnDates;
    private List<String> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dates = new ArrayList<String>();

        eventDate = (EditText) findViewById(R.id.txtEventDate);
        eventDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreateActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        eventDateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        eventDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = (int)month + 1;
                eventDate.setText(dayOfMonth + "-" + month + "-" + year);
            }
        };

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtEventName = (EditText)findViewById(R.id.txtEventName);
                EditText txtDescription = (EditText)findViewById(R.id.txtDescription);
                EditText txtLocation = (EditText)findViewById(R.id.txtLocation);
                EditText txtEventDate = (EditText)findViewById(R.id.txtEventDate);

                // TODO: check validity
                if(true){
                    Event newEvent = new Event(
                            -1,
                            txtEventName.getText().toString(),
                            txtLocation.getText().toString(),
                            txtDescription.getText().toString(),
                            GlobalData.currentUser.getId(),
                            txtEventDate.getText().toString(),
                            dates);
                    newEvent.addInvitedUser(new Tuple<Integer, InviteState>(new Integer(newEvent.getCreator()), InviteState.Accepted));

                    FBRepository.getInstance().createOrUpdateEvent(newEvent);
                    finish();
                }

            }
        });

        btnDates = (Button) findViewById(R.id.btnDates);
        btnDates.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(CreateActivity.this, ManageDates.class);
                intent.putStringArrayListExtra("dates", (ArrayList<String>) dates);
                startActivityForResult(intent,1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == ManageDates.RESULT_OK){
                List<String> resultDates = new ArrayList<String>();
                resultDates = data.getStringArrayListExtra("dates");
                dates = resultDates;
            }
            if (resultCode == ManageDates.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
