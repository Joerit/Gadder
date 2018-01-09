package be.ap.eaict.gadder.DOM;


import java.util.Calendar;

/**
 * Created by Ruben on 9-1-2018.
 */

public class Datum {
    private Calendar datum;
    private String[] dateParts;

    public Datum(String dateFull){
        this.datum = Calendar.getInstance();
        this.dateParts = dateFull.split("-");
        fillDateObject();
    }
    public Calendar getDatum ()
    {
        return this.datum;
    }

    private void fillDateObject(){
        int day = Integer.parseInt(this.dateParts[0]);
        int month = Integer.parseInt(this.dateParts[1]);
        int year = Integer.parseInt(this.dateParts[2]);
        this.datum.set(year,month,day);
    }
}
