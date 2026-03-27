package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addTheFirstProduct(){

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();
    }

    public void addTheSecondProduct(){

        WebElement addToCartButton = driver.findElement(By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']"));
        addToCartButton.click();
    }

    public void toCart(){

        WebElement cartButton = driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"));
        cartButton.click();
    }

}
