package be.ap.eaict.gadder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class MyAdapter extends ArrayAdapter<Event> {
    private final Context context;
    private final List<Event> values;

    public MyAdapter(Context context, List<Event> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customlayout, parent, false);

        //Insert data
        TextView txtNaam = (TextView)rowView.findViewById(R.id.txtNaam);
        txtNaam.setText(values.get(position).getName());
        //

        return rowView;
    }
}
