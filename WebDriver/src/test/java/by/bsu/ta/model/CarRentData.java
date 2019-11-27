package by.bsu.ta.model;

import java.util.Objects;

public class CarRentData {

    private String pickUpLocation;
    private String dropOffLocation;

    public CarRentData(String pickUpLocation, String dropOffLocation) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    @Override
    public String toString() {
        return "CarRentData{" +
                "pickUpLocation='" + pickUpLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRentData that = (CarRentData) o;
        return Objects.equals(pickUpLocation, that.pickUpLocation) &&
                Objects.equals(dropOffLocation, that.dropOffLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpLocation, dropOffLocation);
    }
}
