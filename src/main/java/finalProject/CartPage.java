package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage() {
        super(DriverManager.getDriver());
    }

    private By firstItem = By.xpath("//div[text() ='Sauce Labs Backpack']");

    private By secondItem = By.xpath("//div[text() ='Sauce Labs Bike Light']");

    private By checkoutButton = By.cssSelector("[id = 'checkout']");

    public String getFirstProductName(){
        return getText(firstItem);
    }

    public String getSecondProductName(){
        return getText(secondItem);
    }

    public void clickCheckout(){
        click(checkoutButton);
    }
}
