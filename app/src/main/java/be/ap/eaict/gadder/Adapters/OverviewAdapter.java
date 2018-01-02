package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.User;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class OverviewAdapter extends ArrayAdapter<Event> {
    private final Context context;
    private final List<Event> values;
    String strCreator;

    public OverviewAdapter(Context context, List<Event> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customoverviewlayout, parent, false);

        //Insert data

        TextView txtNaam = (TextView)rowView.findViewById(R.id.txtNaam);
        TextView txtDatum = (TextView) rowView.findViewById(R.id.txtDatum);
        TextView txtInvitedOrCreator = (TextView) rowView.findViewById(R.id.txtInvitedOrCreator);


        txtNaam.setText(values.get(position).getName());
        txtDatum.setText(values.get(position).getStartDate());




        for (User user: FBRepository.getInstance().getUsers()) {
            if(user.getId() == values.get(position).getCreator()){
                strCreator = user.getUsername();
            }

        }

        txtInvitedOrCreator.setText(strCreator);
        //

        return rowView;
    }
}
