package td4.tp_parking;

public class LocationArchiver {

    private Location location;
    private boolean carIsReturnedInTime;
    private boolean carIsInGoodState;

    public LocationArchiver(Location location, boolean carIsReturnedInTime, boolean carIsInGoodState) {
        this.location = location;
        this.carIsReturnedInTime = carIsReturnedInTime;
        this.carIsInGoodState = carIsInGoodState;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isCarIsReturnedInTime() {
        return carIsReturnedInTime;
    }

    public void setCarIsReturnedInTime(boolean carIsReturnedInTime) {
        this.carIsReturnedInTime = carIsReturnedInTime;
    }

    public boolean isCarIsInGoodState() {
        return carIsInGoodState;
    }

    public void setCarIsInGoodState(boolean carIsInGoodState) {
        this.carIsInGoodState = carIsInGoodState;
    }
}
