package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(){
        super(DriverManager.getDriver());
    }

    private By finishButton = By.cssSelector("[id='finish']");

    private By firstPriceField = By.xpath("//div[@data-test='inventory-item-price']");

    private By secondPriceField = By.xpath("(//div/*[@data-test='inventory-item-price'])[2]");

    private By totalSumField = By.cssSelector("[data-test='subtotal-label']");

    public void clickFinishButton(){
        click(finishButton);
    }

    public double sumOfTwoProducts(){

        double firstPrice = Double.parseDouble(getText(firstPriceField).replace("$", ""));
        double secondPrice = Double.parseDouble(getText(secondPriceField).replace("$", ""));

        return firstPrice + secondPrice;
    }

    public double totalSum(){

        return Double.parseDouble(getText(totalSumField).replace("Item total: $", ""));
    }
}
