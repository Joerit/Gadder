package be.ap.eaict.gadder.DOM;


import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Ruben on 9-1-2018.
 */

public class Datum {
    private Calendar datum;
    private String[] dateParts;
    private ArrayList<Calendar> dates;

    public Datum(){
        this.datum = new GregorianCalendar();
    }

    public Calendar getDatum(String dateFull)
    {
        this.dateParts = dateFull.split("-");
        int day = Integer.parseInt(this.dateParts[0]);
        int month = Integer.parseInt(this.dateParts[1]);
        int year = Integer.parseInt(this.dateParts[2]);
        this.datum.set(Calendar.YEAR, year);
        this.datum.set(Calendar.MONTH, month -1);
        this.datum.set(Calendar.DAY_OF_MONTH, day);
        return this.datum;
    }

    public List<String> bubbleSort(ArrayList<String> datesString){
        this.dates = new ArrayList<Calendar>();
        List<String> datesSorted = new ArrayList<String>();

        for (String item : datesString){
            this.dateParts = item.split("-");
            Calendar dateTemp = new GregorianCalendar();
            dateTemp.set(Calendar.YEAR, Integer.parseInt(this.dateParts[2]));
            dateTemp.set(Calendar.MONTH, Integer.parseInt(this.dateParts[1])-1);
            dateTemp.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.dateParts[0]));
            this.dates.add(dateTemp);
        }

        Collections.sort(this.dates);

        for (Calendar item : this.dates){
            String dateFull = String.valueOf(item.get(Calendar.DAY_OF_MONTH))+"-"+String.valueOf(item.get(Calendar.MONTH)+1)+"-"+String.valueOf(item.get(Calendar.YEAR));
            datesSorted.add(dateFull);
        }
        return datesSorted;
    }
}
