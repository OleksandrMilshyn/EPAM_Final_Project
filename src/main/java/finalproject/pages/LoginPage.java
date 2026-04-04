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

    public void userName(String login){
        sendKeys(loginField, login);
    }

    public void userPassword(String password){
        sendKeys(passwordField, password);
    }

    private void clickLoginButton(){
        click(loginButton);
    }

    public ProductsPage loginAsDefaultUser(){
        userName(ConfigReader.get("login"));
        userPassword(ConfigReader.get("password"));
        clickLoginButton();

        return new ProductsPage();
    }
}
