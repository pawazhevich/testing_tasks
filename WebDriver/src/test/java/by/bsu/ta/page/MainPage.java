package by.bsu.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://www.autoeurope.com/";

    @FindBy(xpath = "//*[@id=\"ae-search\"]/div[3]/div[6]/button")
    private WebElement findYourCarButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public void submitCarRent() {
        this.findYourCarButton.click();
    }

}
