package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userName(String login){

        WebElement loginField = driver.findElement(By.cssSelector("[id ='user-name']"));
        loginField.sendKeys(login);
    }

    public void userPassword(String password){

        WebElement passwordField = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordField.sendKeys(password);
    }

    public void logIn(){

        WebElement loginButton = driver.findElement(By.cssSelector("[id='login-button']"));
        loginButton.click();
    }
}
