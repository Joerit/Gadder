package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.ap.eaict.gadder.DOM.User;
import be.ap.eaict.gadder.R;

/**
 * Created by Kevin-Laptop on 22/12/2017.
 */

public class FriendslistAdapter extends ArrayAdapter<User> {
    private final Context context;
    private final List<User> values;

    public FriendslistAdapter(Context context, List<User> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customfriendslayout, parent, false);

        //Insert data
        TextView txtFriendName = (TextView)rowView.findViewById(R.id.txtFriendName);
        txtFriendName.setText(values.get(position).getUsername());
        //
        //Filter on Accepter invites

        return rowView;
    }
}
