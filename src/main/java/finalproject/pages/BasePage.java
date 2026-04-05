package finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected String getText(By locator){
        return find(locator).getText();
    }

    protected void sendKeys(By locator, String text){
        find(locator).sendKeys(text);
    }
}
