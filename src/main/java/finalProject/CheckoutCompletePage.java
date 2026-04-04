package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage() {
        super(DriverManager.getDriver());
    }

    private By completeOrderText = By.xpath("//h2[text() = 'Thank you for your order!']");

    public String getCompleteOrderText(){
        return getText(completeOrderText);
    }
}
