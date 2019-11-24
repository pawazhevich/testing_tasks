package airport;

import entity.ExperimentalPlane;
import entity.MilitaryPlaneType;
import entity.MilitaryPlane;
import entity.PassengerPlane;
import entity.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private <T extends Plane> List<T> getListPlanes(Class<T> concretePlane) {
        List<T> specificPlanes = new ArrayList<>();
        planes.stream()
                .filter(concretePlane::isInstance)
                .forEach(plane -> {
                    specificPlanes.add(concretePlane.cast(plane));
                });

        return specificPlanes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return getListPlanes(PassengerPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return getListPlanes(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return getListPlanes(ExperimentalPlane.class);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for(PassengerPlane plane: passengerPlanes) {
            if(plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = plane;
            }
        }
        return planeWithMaxCapacity;
    }

    private List<MilitaryPlane> getMilitaryPlanesOfType(MilitaryPlaneType type) {
        return this.getMilitaryPlanes()
                .stream()
                .filter(plane -> plane.getMilitaryPlaneType() == type)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesOfType(MilitaryPlaneType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesOfType(MilitaryPlaneType.BOMBER);
    }

    @Override
    public String toString() {
        return "airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }


}
