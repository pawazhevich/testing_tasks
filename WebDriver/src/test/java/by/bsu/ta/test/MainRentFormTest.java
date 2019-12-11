package by.bsu.ta.test;

import by.bsu.ta.model.CarRentData;
import by.bsu.ta.page.MainPage;
import by.bsu.ta.service.CarRentDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class MainRentFormTest extends CommonConditions {

    @Test
    public void rentFormCanNotBeEmpty() {
        MainPage mainPage = new MainPage(driver).openPage();
        Assert.assertFalse(mainPage.isPickUpLocationAlertDisplayed());
        mainPage.submitCarRentForm();
        Assert.assertTrue(mainPage.isPickUpLocationAlertDisplayed());
    }

    @Test
    public void driverAgeCanNotBeLessThenAdult() {
        MainPage mainPage = new MainPage(driver).openPage();
        CarRentData testRentData = CarRentDataCreator.withLocationsFromDifferentContinents();
        mainPage.fillCarRentFrom(testRentData);
        mainPage.disableCheckBoxDriverAge();
        mainPage.fillDriverAge(14);
        mainPage.submitCarRentForm();
        Assert.assertTrue(mainPage.isInvalidAgeSelectionAlertDisplayed());
    }
}
