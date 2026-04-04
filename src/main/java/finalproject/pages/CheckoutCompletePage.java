package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage() {
        super(DriverManager.getDriver());
    }

    private By completeOrderText = By.xpath("//h2[text() = 'Thank you for your order!']");

    public String getCompleteOrderText(){
        return getText(completeOrderText);
    }
}
