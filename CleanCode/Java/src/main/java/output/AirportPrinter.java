package output;

import airport.Airport;

public class AirportPrinter {
    public static void printPlanesToConsole(Airport airport) {
        airport.getPlanes().forEach(System.out::println);
    }
}
