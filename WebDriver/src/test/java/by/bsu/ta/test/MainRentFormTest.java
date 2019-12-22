package by.bsu.ta.test;

import by.bsu.ta.model.CarRentData;
import by.bsu.ta.page.MainPage;
import by.bsu.ta.service.CarRentDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainRentFormTest extends CommonConditions {

    @Test
    public void rentFormCanNotBeEmpty() {
        MainPage mainPage = new MainPage(driver).openPage();
        mainPage.submitCarRentForm();
        Assert.assertTrue(mainPage.isPickUpLocationAlertDisplayed());
    }

    @Test
    public void driverAgeCanNotBeLessThenAdult() {
        CarRentData testRentData = CarRentDataCreator.withLocationsFromDifferentContinents();

        MainPage mainPage = new MainPage(driver).openPage()
        .fillCarRentFrom(testRentData)
        .disableCheckBoxDriverAge()
        .fillDriverAge(14);
        mainPage.submitCarRentForm();
        Assert.assertTrue(mainPage.isInvalidAgeSelectionAlertDisplayed());
    }

}
