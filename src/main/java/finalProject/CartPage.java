package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){

        WebElement name = driver.findElement(By.xpath("//div[text() ='Sauce Labs Backpack']"));
        return name.getText();
    }

    public String getProductName2(){

        WebElement name = driver.findElement(By.xpath("//div[text() ='Sauce Labs Bike Light']"));
        return name.getText();
    }

    public void clickCheckout(){

        WebElement checkoutButton = driver.findElement(By.cssSelector("[id = 'checkout']"));
        checkoutButton.click();
    }
}
