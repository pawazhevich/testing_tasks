package by.bsu.ta.service;

import by.bsu.ta.model.CarRentData;

public class CarRentDataCreator {

    public static final String TESTDATA_PICK_UP_LOCATION = "New York";
    public static final String TESTDATA_DROP_OFF_LOCATION = "London";

    public static CarRentData withLocationsFromDifferentContinents() {
        return new CarRentData(TESTDATA_PICK_UP_LOCATION, TESTDATA_DROP_OFF_LOCATION);
    }

}
