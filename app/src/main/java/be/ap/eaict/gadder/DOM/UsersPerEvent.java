package be.ap.eaict.gadder.DOM;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class UsersPerEvent {

    private int userId;
    private int eventId;
    private int status; // 0 = INVITED | 1 = ACCEPTED | -1 = DECLINED

    public UsersPerEvent(int userId, int eventId, int status){
        this.userId = userId;
        this.eventId = eventId;
        this.status = status;
    }

    public int getUserId(int eventId) {
        if(this.eventId == eventId){
            return userId;
        }
        return -1;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
