package by.bsu.ta.test;

import by.bsu.ta.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageTest extends CommonConditions {

    @Test
    public void urlChangesAfterLanguageChange() {
        MainPage mainPage = new MainPage(driver).openPage();
        mainPage.switchLanguage();
        Assert.assertNotEquals(driver.getCurrentUrl(), mainPage.getBaseUrl());
    }

    @Test
    public void windowConfigDisplayByButton() {
        Assert.assertTrue(new MainPage(driver)
                .openPage()
                .clickConfigButton()
                .isConfigWindowDisplayed());
    }
}
