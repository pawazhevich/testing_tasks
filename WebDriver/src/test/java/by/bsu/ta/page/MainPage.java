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
        return new RentSearchResultPage(driver);
    }

    public void fillCarRentFrom(CarRentData rentData) {

        selectInputValueFromDropList(inputPickUpLocation, rentData.getPickUpLocation(), firstMatchingPickUpLocation);
        selectInputValueFromDropList(inputDropOffLocation, rentData.getDropOffLocation(), firstMatchingDropOffLocation);
    }

    private void selectInputValueFromDropList(WebElement input, String subValue, WebElement matchingElement) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        ExpectedCondition<WebElement> waitCondition = ExpectedConditions.visibilityOf(matchingElement);
        input.sendKeys(subValue);
        wait.until(waitCondition);
        matchingElement.click();
        wait.until(ExpectedConditions.not(waitCondition));
    }

    public boolean isPickUpLocationAlertDisplayed() {
        try {
            return enterPickUpLocationAlert.isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.warn("PickUp location alert element not found");
            return false;
        }

    }
}
