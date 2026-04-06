package finalproject.tests;

import finalproject.pages.*;
import finalproject.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class PositiveTests {

    String expectedFirstName = "Sauce Labs Backpack";
    String expectedSecondName = "Sauce Labs Bike Light";
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
    public void verifyProductPresentInCartTest() {

        String actualName = new LoginPage()
                .loginAsDefaultUser()
                .addSauceLabsBackpack()
                .openCart()
                .getFirstProductName();

        Assert.assertEquals(actualName, expectedFirstName);
    }

    @Test
    public void verifyOrderOfProductTest() {

        String actualFinalText = new LoginPage()
                .loginAsDefaultUser()
                .addSauceLabsBackpack()
                .openCart()
                .clickCheckout()
                .fillCheckoutInformation(myFirstName, myLastName, myPostCode)
                .clickContinue()
                .clickFinishButton()
                .getCompleteOrderText();

        Assert.assertEquals(actualFinalText, expectedFinalText);
    }

    @Test
    public void verifySeveralProductsInCartTest() {

        CartPage cartPage = new LoginPage()
                .loginAsDefaultUser()
                .addSauceLabsBackpack()
                .addSauceLabsBikeLight()
                .openCart();

        List<String> actualResult = List.of(
                cartPage.getFirstProductName(),
                cartPage.getSecondProductName());

        List<String> expectedResult = List.of(expectedFirstName, expectedSecondName);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyTotalPriceTest() {

        CheckoutOverviewPage checkoutOverviewPage = new LoginPage()
                .loginAsDefaultUser()
                .addSauceLabsBackpack()
                .addSauceLabsBikeLight()
                .openCart()
                .clickCheckout()
                .fillCheckoutInformation(myFirstName, myLastName, myPostCode)
                .clickContinue();

        Assert.assertEquals(
                checkoutOverviewPage.sumOfTwoProducts(),
                checkoutOverviewPage.totalSum());
    }

    @Test
    public void verifyOrderOfSeveralProductsTest() {

        String actualFinalText = new LoginPage()
                .loginAsDefaultUser()
                .addSauceLabsBackpack()
                .addSauceLabsBikeLight()
                .openCart()
                .clickCheckout()
                .fillCheckoutInformation(myFirstName, myLastName, myPostCode)
                .clickContinue()
                .clickFinishButton()
                .getCompleteOrderText();

        Assert.assertEquals(actualFinalText, expectedFinalText);
    }
}
