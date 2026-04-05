package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

    public ProductsPage() {
        super(DriverManager.getDriver());
    }

    private By backpackButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    private By bikeLightButton = By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']");

    private By cartButton = By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage addSauceLabsBackpack() {
        log.info("Add product to cart: Sauce Labs Backpack");
        click(backpackButton);
        return this;
    }

    public ProductsPage addSauceLabsBikeLight() {
        log.info("Add product to cart: Sauce Labs Bike Light");
        click(bikeLightButton);
        return this;
    }

    public CartPage openCart() {
        log.info("Open cart");
        click(cartButton);
        return new CartPage();
    }
}
