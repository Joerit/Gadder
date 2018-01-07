package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.ap.eaict.gadder.DOM.Event;
import be.ap.eaict.gadder.DOM.FBRepository;
import be.ap.eaict.gadder.DOM.User;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 7/01/2018.
 */

public class InvitationAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final List<User> values;


    public InvitationAdapter(Context context, List<User> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customfriendsineventlayout, parent, false);


        //Insert data

        TextView txtFriendNameForEvent = (TextView) rowView.findViewById(R.id.txtInviteFriendInEventName);


        txtFriendNameForEvent.setText(values.get(position).getUsername());

        //

        return rowView;
    }
}
