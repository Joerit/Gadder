package be.ap.eaict.gadder;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Ruben on 3-1-2018.
 */

public class ManageDates extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener addDateListener;
    private EditText addDate;
    private Button btnAddDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managedates);

        addDate = (EditText) findViewById(R.id.txtAddDate);

        addDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ManageDates.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        addDateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        addDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = (int)month + 1;
                addDate.setText(dayOfMonth + "-" + month + "-" + year);
            }
        };

        btnAddDate = (Button) findViewById(R.id.btnAddDate);
        btnAddDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}
