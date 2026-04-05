package finalproject.pages;

import finalproject.utils.DriverManager;
import org.openqa.selenium.By;

public class CheckoutInformationPage extends BasePage{

    public CheckoutInformationPage() {
        super(DriverManager.getDriver());
    }

    private By firstNameField = By.cssSelector("[id='first-name']");

    private By lastNameField = By.cssSelector("[id='last-name']");

    private By postCodeField = By.cssSelector("[id='postal-code']");

    private By continueButton = By.cssSelector("[id='continue']");

    private By errorMessage = By.cssSelector("[data-test='error']");

    public void fillAllFields(String firstName, String lastName, String postCode){
        log.info("Fill checkout information");

        sendKeys(firstNameField, firstName);
        sendKeys(lastNameField, lastName);
        sendKeys(postCodeField, postCode);
    }

    public void clickContinue(){
        log.info("Continue to overview");

        click(continueButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
