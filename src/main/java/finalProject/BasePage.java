package finalProject;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //TODO What's the point of creating this class? What can we put here?
    // It's should be a placeholder for all common methods that we can reuse in other pages.
    // For example, we can create a method to find element by xpath and reuse it
    // in other pages instead of writing the same code again and again.
    // DRY - Don't Repeat Yourself
}
