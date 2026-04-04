package finalProject.tests;

import finalProject.ConfigReader;
import finalProject.DriverFactory;
import finalProject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(String browser){

        DriverFactory.initDriver(browser);

        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void quitDriver(){
        DriverFactory.quitDriver();
    }

    protected void login(){
        new LoginPage().login(ConfigReader.get("login"), ConfigReader.get("password"));
    }
}

