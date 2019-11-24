package run;

import airport.Airport;
import data.PlaneProvider;
import util.AirportSorter;

public class Runner {

    public static void main(String[] args) {
        PlaneProvider planeProvider = new PlaneProvider();

        Airport airport = new Airport(planeProvider.getAllPlanes());
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());

        AirportSorter militaryAirportSorter = new AirportSorter(militaryAirport);
        AirportSorter passengerAirportSorter = new AirportSorter(passengerAirport);

        System.out.println("Military airport sorted by max distance: " + militaryAirportSorter
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirportSorter
                .sortByMaxSpeed()
                .toString());

        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
