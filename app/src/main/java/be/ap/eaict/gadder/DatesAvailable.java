package be.ap.eaict.gadder;


import java.util.Calendar;
import java.util.List;


/**
 * Created by Ruben on 29-12-2017.
 */

public class DatesAvailable {

    private int eventId;
    private int userId;
    private List<String> dates;
    private int status;
    private boolean valid;

    public DatesAvailable(int eventId, int userId, List<String> dates, int status) {
        this.eventId = eventId;
        this.userId  = userId;
        this.dates = dates;
        this.status = status;
        valid = false;
        Validation();
    }

    private void Validation(){
        if (status == 1) {
            valid = true;
        }else {
            valid = false;
        }
    }

    public List<String> getDates(){
        return dates;
    }

    public void addDate(String date) {
        dates.add(date);
    }
    public void removeDate(String date){
        dates.remove(date);
    }
}
