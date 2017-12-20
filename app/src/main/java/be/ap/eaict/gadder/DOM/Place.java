package be.ap.eaict.gadder.DOM;

/**
 * Created by Kevin-Laptop on 20/12/2017.
 */

public class Place {

    private  int id;
    private String name;
    private String address;
    private float lattitude;
    private float longitude;

    public Place(int id, String name, String address, float lattitude, float longitude){
        this.id = id;
        this.name = name;
        this.address = address;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
