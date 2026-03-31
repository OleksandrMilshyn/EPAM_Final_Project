package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
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

    public void logIn(){
        click(loginButton);
    }
}
