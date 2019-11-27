package by.bsu.ta.test;

import by.bsu.ta.model.CarRentData;
import by.bsu.ta.page.MainPage;
import by.bsu.ta.page.RentSearchResultPage;
import by.bsu.ta.service.CarRentDataCreator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarRentTest extends CommonConditions {

    @Test
    public void cantPickUpAndDropOffInDifferentContinents(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        CarRentData testRentData = CarRentDataCreator.withLocationsFromDifferentContinents();

        MainPage mainPage = new MainPage(driver).openPage();
        mainPage.fillCarRentFrom(testRentData);
        RentSearchResultPage resultPage = mainPage.submitCarRentForm();
        wait.until(ExpectedConditions.urlToBe("https://www.autoeurope.com/results/"));
        Assert.assertTrue(resultPage.isSearchAgainMessageDisplayed());
    }
}
