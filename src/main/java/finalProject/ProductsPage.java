package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    public ProductsPage() {
        super(DriverManager.getDriver());
    }

    private By addToCartFirstItemButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    private By addToCartSecondItemButton = By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']");

    private By cartButton = By.cssSelector("[data-test='shopping-cart-link']");

    public void addTheFirstProduct(){
        click(addToCartFirstItemButton);
    }

    public void addTheSecondProduct(){
        click(addToCartSecondItemButton);
    }

    public void toCart(){
        click(cartButton);
    }
}
