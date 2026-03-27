package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getCompleteOrderText(){

        WebElement textCompleteOrderText = driver.findElement(By.xpath("//h2[text() = 'Thank you for your order!']"));
        return textCompleteOrderText.getText();
    }
}
