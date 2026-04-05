package finalproject.pages;

import finalproject.utils.ConfigReader;
import finalproject.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private WebDriver driver;

    public LoginPage() {
        super(DriverManager.getDriver());
    }

    private By loginField = By.cssSelector("[id ='user-name']");

    private By passwordField = By.xpath("//input[@name = 'password']");

    private By loginButton = By.cssSelector("[id='login-button']");

    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage userName(String login){
        sendKeys(loginField, login);
        return this;
    }

    public LoginPage userPassword(String password){
        sendKeys(passwordField, password);
        return this;
    }

    public LoginPage clickLoginButton(){
        log.info("Click login button");
        click(loginButton);
        return this;
    }

    public ProductsPage loginAsDefaultUser(){
        log.info("Login with default user");

        userName(ConfigReader.get("login"));
        userPassword(ConfigReader.get("password"));
        clickLoginButton();

        log.info("Login successful, opening Products page");

        return new ProductsPage();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
