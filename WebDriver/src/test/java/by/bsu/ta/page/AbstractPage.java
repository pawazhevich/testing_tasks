package by.bsu.ta.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 30;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPage scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public long getScrollPosition() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (long)jse.executeScript("return window.pageYOffset");
    }

}
