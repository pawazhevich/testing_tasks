package by.bsu.ta.test;

import by.bsu.ta.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainRentFormTest extends CommonConditions {

    @Test
    public void rentFormCanNotBeEmpty() {
        MainPage mainPage = new MainPage(driver).openPage();
        Assert.assertFalse(mainPage.isPickUpLocationAlertDisplayed());
        mainPage.submitCarRentForm();
        Assert.assertTrue(mainPage.isPickUpLocationAlertDisplayed());
    }

}
