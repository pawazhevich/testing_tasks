package by.bsu.ta.test;

import by.bsu.ta.page.MainPage;
import org.testng.annotations.Test;

public class TestTest extends CommonConditions{

    @Test
    public void OpenPage() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.submitCarRent();
            
    }
}
