package finalProject;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void start(String browser){
        driver.set(DriverFactory.createDriver(browser));
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void stop(){
        WebDriver drv = driver.get();
        if (drv != null){
            drv.quit();
            driver.remove();
        }
    }
}
