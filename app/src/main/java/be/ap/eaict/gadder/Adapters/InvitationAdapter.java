package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private final Event event;


    public InvitationAdapter(Context context, List<User> values, Event event) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.event = event;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customfriendsineventlayout, parent, false);


        //Insert data

        TextView txtFriendNameForEvent = (TextView) rowView.findViewById(R.id.txtInviteFriendInEventName);
        final Button btnInviteFriend = (Button)rowView.findViewById(R.id.btnInviteFriend);

        txtFriendNameForEvent.setText(values.get(position).getUsername());
        btnInviteFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.addInvitedUser(values.get(position));
                FBRepository.getInstance().updateEvent(event);
                values.get(position).addEvent(event);
                FBRepository.getInstance().updateUser(values.get(position));
                Toast.makeText(context, "added " + values.get(position).getUsername(), Toast.LENGTH_SHORT).show();
                btnInviteFriend.setEnabled(false);
                btnInviteFriend.setBackgroundColor(Color.GRAY);
            }
        });

        //

        return rowView;
    }
}
