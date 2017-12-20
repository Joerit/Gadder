package be.ap.eaict.gadder.DOM;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */


public class FriendsPerUser {

private int userId;
private int friendId;
private int status;  // 0 = INVITED | 1 = ACCEPTED | -1 = DECLINED


    public FriendsPerUser(int userId, int friendId, int status){
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
