package finalProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false); // ← ВАЖНО
            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerEnabled");

            options.addArguments("--incognito");

            driver.set(new ChromeDriver(options));
        }
        else if (browser.equalsIgnoreCase("firefox")){
            driver.set(new FirefoxDriver());
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser + " please use chrome or firefox");
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}
