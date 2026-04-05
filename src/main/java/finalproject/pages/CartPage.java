package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

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

    public CheckoutInformationPage clickCheckout() {
        log.info("Proceed to checkout");
        click(checkoutButton);
        return new CheckoutInformationPage();
    }
}
