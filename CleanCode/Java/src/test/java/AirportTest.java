import airport.Airport;
import data.PlaneProvider;
import entity.ExperimentalPlane;
import entity.ClassificationPlaneLevel;
import entity.ExperimentalPlaneType;
import entity.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import entity.MilitaryPlane;
import entity.PassengerPlane;
import entity.Plane;
import util.AirportSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes;
    private PassengerPlane planeWithMaxPassengerCapacity;
    private Airport airport;

    @BeforeMethod
    public void initParams() {
        planes = new PlaneProvider().getAllPlanes();
        airport = new Airport(planes);
        planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    }

    @Test
    public void airportHasTransportMilitaryPlane() {
        Assert.assertTrue(airport.getTransportMilitaryPlanes()
                .stream()
                .anyMatch(plane -> MilitaryPlaneType.TRANSPORT.equals(plane.getMilitaryPlaneType())));
    }

    @Test
    public void airportHasPassengerPlaneWithMaxCapacity() {
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), planeWithMaxPassengerCapacity);
    }

    @Test
    public void isAirportPlanesSortedByMaxLoadCapacity() {
        AirportSorter airportSorter = new AirportSorter(airport);
        airportSorter.sortByMaxLoadCapacity();
        planes.sort(Comparator.comparing(Plane::getMaxLoadCapacity));
        Assert.assertEquals(planes, airport.getPlanes());
    }

    @Test
    public void airportHasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(airport.getBomberMilitaryPlanes()
                .stream()
                .anyMatch(plane -> MilitaryPlaneType.BOMBER.equals(plane.getMilitaryPlaneType())));
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Assert.assertFalse(airport.getExperimentalPlanes()
                .stream()
                .allMatch(plane -> ClassificationPlaneLevel.UNCLASSIFIED.equals(plane.getClassificationPlaneLevel())));
    }
}
