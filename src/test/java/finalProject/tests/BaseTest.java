package finalProject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(String browser){
        //TODO: It's of to have some common logic for preconditions,
        // but configuration of your webdriver better to encapsulate in some separate class.
        // For example, we can create a DriverFactory class that will be responsible for
        // creating and configuring the webdriver.
        // This way we can keep our test code clean and maintainable.
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        //TODO: What's happens if we will pass some other value for browser?
        // We can add some validation here and throw an exception if the value is not valid.
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}

