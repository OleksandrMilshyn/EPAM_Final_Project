package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends BasePage{

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstName(String firstName){

        WebElement firstNameField = driver.findElement(By.cssSelector("[id='first-name']"));
        firstNameField.sendKeys(firstName);
    }

    public void addLastName(String lastName){

        WebElement firstNameField = driver.findElement(By.cssSelector("[id='last-name']"));
        firstNameField.sendKeys(lastName);
    }

    public void addPostCode(String postCode){

        WebElement firstNameField = driver.findElement(By.cssSelector("[id='postal-code']"));
        firstNameField.sendKeys(postCode);
    }

    public void clickContinue(){

        WebElement continueButton = driver.findElement(By.cssSelector("[id='continue']"));
        continueButton.click();
    }
}
