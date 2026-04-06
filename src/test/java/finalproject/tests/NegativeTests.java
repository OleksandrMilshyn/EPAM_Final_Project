package finalproject.tests;

import finalproject.pages.*;
import finalproject.utils.ConfigReader;
import finalproject.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeTests {

    String myFirstName = "OLEKSANDR";
    String myLastName = "MILSHYN";
    String myPostCode = "00-444";
    String expectedFinalText = "Thank you for your order!";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        DriverManager.start(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.stop();
    }

    @Test
    public void verifyInvalidLoginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.userName(ConfigReader.get("login"));
        loginPage.userPassword(ConfigReader.get("invalid_password"));
        loginPage.clickLoginButton();

        String actualError = loginPage.getErrorMessage();

        Assert.assertTrue(actualError.contains("Username and password do not match"));
    }

    @Test
    public void verifyCheckoutWithEmptyInformationTest() {

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.clickContinue();

        String actualError = checkoutInformationPage.getErrorMessage();

        Assert.assertTrue(actualError.contains("Error: First Name is required"));
    }

    @Test
    public void verifyCheckoutWithEmptyCartTest() {

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.fillCheckoutInformation(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        String actualText = checkoutCompletePage.getCompleteOrderText();

        Assert.assertEquals(actualText, expectedFinalText);
    }
}