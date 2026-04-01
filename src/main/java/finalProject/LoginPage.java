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

    private void clickLoginButton(){
        click(loginButton);
    }

    public void login(String name, String password){
        userName(name);
        userPassword(password);
        clickLoginButton();
    }
}
