package finalProject.tests;

import finalProject.ConfigReader;
import finalProject.DriverFactory;
import finalProject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(String browser){

        driver = DriverFactory.createDriver(browser);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    protected void login(){
        new LoginPage(driver).login(ConfigReader.get("login"), ConfigReader.get("password"));
    }
}

