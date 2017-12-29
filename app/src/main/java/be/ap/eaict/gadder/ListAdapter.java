package be.ap.eaict.gadder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ruben on 29-12-2017.
 */

public class ListAdapter extends ArrayAdapter<DatesAvailable> {
    private final Context context;
    private final List<DatesAvailable> values;

    public ListAdapter(Context context, List<DatesAvailable> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.date_list_item, parent, false);

        TextView textViewDate = (TextView) rowView.findViewById(R.id.txtDate);

        //Datum String maken
        String d = String.valueOf(values.get(position).getDay());
        String m = String.valueOf(values.get(position).getMonth());
        String yyyy = String.valueOf(values.get(position).getYear());
        String date = d + "/" + m + "/" + yyyy;

        //Tijd String maken
        String hour = String.valueOf(values.get(position).getHour());
        String minute = String.valueOf(values.get(position).getMinute());
        String time = hour + ":" + minute;

        //Velden aanpassen met setText met gegevens van de DatesAvailable repository
        textViewDate.setText(date);

        return rowView;
    }
}