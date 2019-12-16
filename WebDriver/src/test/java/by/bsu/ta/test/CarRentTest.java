package by.bsu.ta.test;

import by.bsu.ta.model.CarRentData;
import by.bsu.ta.page.MainPage;
import by.bsu.ta.service.CarRentDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarRentTest extends CommonConditions {

    @Test
    public void cantPickUpAndDropOffInDifferentContinents() {
        CarRentData testRentData = CarRentDataCreator.withLocationsFromDifferentContinents();

        Assert.assertTrue(
                new MainPage(driver)
                    .openPage()
                    .fillCarRentFrom(testRentData)
                    .submitCarRentForm()
                    .isSearchAgainMessageDisplayed());
    }
}
