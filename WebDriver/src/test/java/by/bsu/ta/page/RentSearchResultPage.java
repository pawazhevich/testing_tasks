package by.bsu.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentSearchResultPage extends AbstractPage {

    private final String BASE_URL = "https://www.autoeurope.com/results";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "search--again__msg")
    private WebElement messageSearchAgain;

    public RentSearchResultPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(BASE_URL));
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RentSearchResultPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("RentSearchResult page opened");
        return this;
    }

    public boolean isSearchAgainMessageDisplayed() {
        try {
            return messageSearchAgain.isDisplayed();
        } catch(NoSuchElementException exception) {
            logger.warn("SearchAgainMessage element not found");
            return false;
        }
    }
}
