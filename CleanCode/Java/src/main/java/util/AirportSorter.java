package util;

import airport.Airport;
import entity.Plane;

import java.util.Collections;
import java.util.Comparator;

public class AirportSorter {

    private Airport airport;

    public AirportSorter(Airport airport) {
        this.airport = airport;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(airport.getPlanes(), Comparator.comparing(Plane::getMaxFlightDistance));
        return airport;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(airport.getPlanes(), Comparator.comparing(Plane::getMaxSpeed));
        return airport;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(airport.getPlanes(),Comparator.comparing(Plane::getMaxLoadCapacity));
        return airport;
    }

}
