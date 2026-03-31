package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By firstItem = By.xpath("//div[text() ='Sauce Labs Backpack']");

    private By secondItem = By.xpath("//div[text() ='Sauce Labs Bike Light']");

    private By checkoutButton = By.cssSelector("[id = 'checkout']");

    public String getProductName(){
        return getText(firstItem);
    }

    public String getProductName2(){
        return getText(secondItem);
    }

    public void clickCheckout(){
        click(checkoutButton);
    }
}
