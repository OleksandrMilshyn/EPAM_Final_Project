package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

    public ProductsPage() {
        super(DriverManager.getDriver());
    }

    private By addToCartFirstItemButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    private By addToCartSecondItemButton = By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']");

    private By cartButton = By.cssSelector("[data-test='shopping-cart-link']");

    public void addSauceLabsBackpack(){
        log.info("Add Sauce Labs Backpack");

        click(addToCartFirstItemButton);
    }

    public void addSauceLabsBikeLight(){
        log.info("Add Sauce Labs Bike Light");

        click(addToCartSecondItemButton);
    }

    public void openCart(){
        log.info("Open cart");

        click(cartButton);
    }
}
