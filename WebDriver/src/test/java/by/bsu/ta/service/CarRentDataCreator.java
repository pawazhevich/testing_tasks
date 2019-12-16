package by.bsu.ta.service;

import by.bsu.ta.model.CarRentData;

public class CarRentDataCreator {

    public static final String TESTDATA_PICK_UP_LOCATION = "testdata.pick_up_location";
    public static final String TESTDATA_DROP_OFF_LOCATION = "testdata.drop_off_location";

    public static CarRentData withLocationsFromDifferentContinents() {

        return new CarRentData(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_DROP_OFF_LOCATION)
        );
    }

}
