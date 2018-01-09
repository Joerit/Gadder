package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import be.ap.eaict.gadder.R;

/**
 * Created by Ruben on 29-12-2017.
 */

public class DatesAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;
    private final List<String> datesSelected;

    public DatesAdapter(Context context, List<String> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.datesSelected = new ArrayList<String>();
    }
    public List<String> getDatesSelected()
    {
        return this.datesSelected;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.date_list_item, parent, false);

        TextView textViewDate = (TextView) rowView.findViewById(R.id.txtDate);
        CheckBox checkDate = (CheckBox) rowView.findViewById(R.id.checkDate);

        checkDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    datesSelected.add(values.get(position));
                }else {
                    datesSelected.remove(values.get(position));
                }
//                List<String> temporary = new ArrayList<String>();
//                for(String call : datesSelected){
//                    Log.d("checkboxchanged", call);
//                }
            }
        });
        //Datum String maken
        String date = String.valueOf(values.get(position));


        //Velden aanpassen met setText met gegevens van de DatesAvailable repository
        textViewDate.setText(date);

        return rowView;
    }
}