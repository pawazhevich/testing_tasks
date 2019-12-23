package by.bsu.ta.page;

import by.bsu.ta.model.CarRentData;
import by.bsu.ta.model.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.autoeurope.com/";

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[6]/button")
    private WebElement buttonFindYourCar;

    @FindBy(id = "ui-id-103")
    private WebElement enterPickUpLocationAlert;

    @FindBy(id = "ui-id-99")
    private WebElement inputPickUpLocation;

    @FindBy(id = "ui-id-102")
    private WebElement inputDropOffLocation;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[4]/dl/dd[1]/div")
    private WebElement firstMatchingPickUpLocation;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[5]/dl/dd[1]/div")
    private WebElement firstMatchingDropOffLocation;

    @FindBy(id = "chk-age")
    private WebElement checkBoxDriverAge;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[3]/div[5]/label")
    private WebElement labelCheckBoxDriverAge;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[5]/input[2]")
    private WebElement inputDriverAge;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[3]/div[5]/div[2]/article/div/header/h5")
    private WebElement invalidAgeSelectionAlert;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/nav/div/ul[2]/li[2]/a")
    private WebElement myAccountLoginButton;

    @FindBy(id = "member_username")
    private WebElement inputEmail;

    @FindBy(id = "member_password")
    private WebElement inputPassword;

    @FindBy(id = "account_login_button")
    private WebElement buttonAccountLogin;

    @FindBy(id = "member-response-left")
    private WebElement loginFailedAlert;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/div[2]/button")
    private WebElement buttonCookieAccept;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(buttonCookieAccept));
        buttonCookieAccept.click();
        return this;
    }

    public RentSearchResultPage submitCarRentForm() {
        this.buttonFindYourCar.click();
        logger.info("Car rent form submit performed");
        if(!driver.getCurrentUrl().equals(this.BASE_URL)) {
            logger.info("Redirecting to Rent Search Result Page");
            return new RentSearchResultPage(driver);
        } else {
            return null;
        }
    }

    public MainPage fillCarRentFrom(CarRentData rentData) {
        logger.info("Filling car rent form with rent data: " + rentData.toString());
        selectInputValueFromDropList(inputPickUpLocation, rentData.getPickUpLocation(), firstMatchingPickUpLocation);
        selectInputValueFromDropList(inputDropOffLocation, rentData.getDropOffLocation(), firstMatchingDropOffLocation);
        return this;
    }

    private MainPage selectInputValueFromDropList(WebElement input, String subValue, WebElement matchingElement) {
        logger.info("Select input value from drop list");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        input.sendKeys(subValue);
        wait.until(ExpectedConditions.elementToBeClickable(matchingElement));
        matchingElement.click();
        wait.until(ExpectedConditions.not(ExpectedConditions
                .not(ExpectedConditions.elementToBeClickable(matchingElement))));
        return this;
    }

    public MainPage loginUser(UserData userData) {
        myAccountLoginButton.click();
        inputEmail.sendKeys(userData.getEmail());
        inputPassword.sendKeys(userData.getPassword());
        logger.info("User data field " + userData.toString());
        buttonAccountLogin.click();
        logger.info("User login submitted ");
        return this;
    }

    public boolean isPickUpLocationAlertDisplayed() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(enterPickUpLocationAlert));
        try {
            return enterPickUpLocationAlert.isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.warn("PickUp location alert element not found");
            return false;
        }
    }

    public MainPage disableCheckBoxDriverAge() {
        if(this.checkBoxDriverAge.isSelected()) {
            this.labelCheckBoxDriverAge.click();
            logger.info("driver check box age disabled");
        }
        return this;
    }

    public MainPage fillDriverAge(int age) {
        this.inputDriverAge.sendKeys(age+"");
        logger.info("driver age set " + age);
        return this;
    }

    public boolean isInvalidAgeSelectionAlertDisplayed() {
        try {
            return invalidAgeSelectionAlert.isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.warn("invalid age selection alert element not found");
            return false;
        }
    }

    public String getLoginFailedAlertMessage() {
        logger.info("Receiving login fail alert message");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(this.loginFailedAlert));
        return this.loginFailedAlert.getText();
    }

    public void switchLanguage() {
        logger.info("Changing language");
        WebElement languageSwitch = driver
                .findElement(By.xpath("/html/body/div[1]/div/div/div/header/div[1]/div[1]/div/li/span"));
        languageSwitch.click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[3]/div[1]/dl[1]/dd/dl/a[1]/dd"))
                .click();
    }

    public String getBaseUrl() {
        return BASE_URL;
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div/nav/div/ul[2]")).isDisplayed();
    }

    public MainPage clickBackToTopButton() {
        WebElement buttonBackToTop = driver.findElement(By.id("back2top"));
        logger.info("Performing back to top button click");
        try {
            buttonBackToTop.click();
        } catch (ElementClickInterceptedException e) {
            logger.info("Back to top button is intercepted");
        }
        return this;
    }

}
