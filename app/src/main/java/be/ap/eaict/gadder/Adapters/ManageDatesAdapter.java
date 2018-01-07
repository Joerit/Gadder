package be.ap.eaict.gadder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

import be.ap.eaict.gadder.R;

/**
 * Created by Ruben on 29-12-2017.
 */

public class ManageDatesAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;
    private ImageButton btnDeleteListItem;

    public ManageDatesAdapter(Context context, List<String> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.date_list_item_managedates, parent, false);

        TextView textViewDate = (TextView) rowView.findViewById(R.id.txtDate);

        //Datum String maken
        String date = String.valueOf(values.get(position));


        //Velden aanpassen met setText met gegevens van de DatesAvailable repository
        textViewDate.setText(date);

        btnDeleteListItem = (ImageButton) rowView.findViewById(R.id.btnDeleteDate);
        btnDeleteListItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                values.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}