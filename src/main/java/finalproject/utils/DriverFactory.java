package finalproject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(String browser){

        if (browser == null){
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                return new ChromeDriver(getChromeOptions());

            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");
                return new FirefoxDriver(options);

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser + " (use chrome or firefox)"
                );
        }
    }

    private static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerEnabled");
        options.addArguments("--incognito");

        return options;
    }
}