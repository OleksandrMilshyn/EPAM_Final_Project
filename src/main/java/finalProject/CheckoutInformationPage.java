package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage{

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameField = By.cssSelector("[id='first-name']");

    private By lastNameField = By.cssSelector("[id='last-name']");

    private By postCodeField = By.cssSelector("[id='postal-code']");

    private By continueButton = By.cssSelector("[id='continue']");

    public void addFirstName(String firstName){
        sendKeys(firstNameField, firstName);
    }

    public void addLastName(String lastName){
        sendKeys(lastNameField, lastName);
    }

    public void addPostCode(String postCode){
        sendKeys(postCodeField, postCode);
    }

    public void clickContinue(){
        click(continueButton);
    }
}
