package be.ap.eaict.gadder;

import android.app.DatePickerDialog;
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

import java.util.Calendar;

import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.GlobalData;
import be.ap.eaict.gadder.DOM.InviteState;
import be.ap.eaict.gadder.DOM.Tuple;

public class CreateActivity extends AppCompatActivity {

    private EditText dateFrom;
    private EditText dateTo;
    private DatePickerDialog.OnDateSetListener fromDateListener;
    private DatePickerDialog.OnDateSetListener toDateListener;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dateFrom = (EditText) findViewById(R.id.txtDateFrom);
        dateTo = (EditText) findViewById(R.id.txtDateTill);

        dateFrom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreateActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        fromDateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateTo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreateActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        toDateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        fromDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = (int)month + 1;
                dateFrom.setText(dayOfMonth + "-" + month + "-" + year);
            }
        };
        toDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = (int)month + 1;
                dateTo.setText(dayOfMonth + "-" + month + "-" + year);
            }
        };

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtEventName = (EditText)findViewById(R.id.txtEventName);
                EditText txtDescription = (EditText)findViewById(R.id.txtDescription);
                EditText txtLocation = (EditText)findViewById(R.id.txtLocation);
                EditText txtDatefrom = (EditText)findViewById(R.id.txtDateFrom);
                EditText txtDateTill = (EditText)findViewById(R.id.txtDateTill);

                // TODO: check validity
                if(true){
                    Event newEvent = new Event(
                            -1,
                            txtEventName.getText().toString(),
                            txtLocation.getText().toString(),
                            txtDescription.getText().toString(),
                            GlobalData.currentUser.getId(),
                            txtDatefrom.getText().toString(),
                            txtDateTill.getText().toString());
                    newEvent.addInvitedUser(new Tuple<Integer, InviteState>(new Integer(newEvent.getCreator()), InviteState.Accepted));
                    FBRepository.getInstance().createOrUpdateEvent(newEvent);
                    finish();
                }

            }
        });


    }
}
