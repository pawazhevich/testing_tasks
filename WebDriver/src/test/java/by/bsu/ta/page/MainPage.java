package by.bsu.ta.page;

import by.bsu.ta.model.CarRentData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
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
        ExpectedCondition<WebElement> waitCondition = ExpectedConditions.visibilityOf(matchingElement);
        input.sendKeys(subValue);
        wait.until(waitCondition);
        matchingElement.click();
        wait.until(ExpectedConditions.not(waitCondition));
        return this;
    }

    public boolean isPickUpLocationAlertDisplayed() {
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
        }
        return this;
    }

    public MainPage fillDriverAge(int age) {
        this.inputDriverAge.sendKeys(age+"");
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
}
