package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    public void clickFinishButton(){

        WebElement finishButton = driver.findElement(By.cssSelector("[id='finish']"));
        finishButton.click();
    }

    public double sumOfTwoProducts(){

        WebElement firstPriceField = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
        String text = firstPriceField.getText();
        text = text.replace("$", "");
        double firstPrice = Double.parseDouble(text);

        WebElement secondPriceField = driver.findElement(By.xpath("(//div/*[@data-test='inventory-item-price'])[2]"));
        String text2 = secondPriceField.getText();
        text2 = text2.replace("$", "");
        double secondPrice = Double.parseDouble(text2);
        return firstPrice + secondPrice;
    }

    public double totalSum(){

        WebElement getTotalSumField = driver.findElement(By.cssSelector("[data-test='subtotal-label']"));
        String text = getTotalSumField.getText();
        text = text.replace("Item total: $", "");
        return Double.parseDouble(text);
    }
}
