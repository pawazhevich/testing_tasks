package by.bsu.ta.test;

import by.bsu.ta.model.UserData;
import by.bsu.ta.page.MainPage;
import by.bsu.ta.service.UserDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonConditions {

    @Test
    public void oneCanNotLoginWithInvalidEmail() {
        String expectedAlertMessage = "PLEASE ENTER A VALID EMAIL AND PASSWORD.";
        UserData userWithInvalidEmail = UserDataCreator.withInvalidEmail();
        Assert.assertEquals( new MainPage(driver)
                .openPage()
                .loginUser(userWithInvalidEmail)
                .getLoginFailedAlertMessage(), expectedAlertMessage);
    }

    @Test
    public void oneCatNotLoginWithIncorrectPassword() {
        String expectedAlertMessage = "PLEASE ENTER A VALID EMAIL AND PASSWORD.";
        UserData userWithIncorrectPassword = UserDataCreator.withIncorrectPassword();
        Assert.assertEquals( new MainPage(driver)
                .openPage()
                .loginUser(userWithIncorrectPassword)
                .getLoginFailedAlertMessage()
                , expectedAlertMessage);
    }
}
