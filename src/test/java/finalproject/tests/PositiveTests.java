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
    public void verifyProductPresentInCartTest(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        String actualName = cartPage.getFirstProductName();
        Assert.assertEquals(actualName, expectedFirstName);
    }

    @Test
    public void verifyOrderOfProductTest(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }

    @Test
    public void verifySeveralProductsInCartTest(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.addSauceLabsBikeLight();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        String actualFirstName = cartPage.getFirstProductName();
        String actualSecondName = cartPage.getSecondProductName();

        List<String> actualResult = List.of(actualFirstName, actualSecondName);
        List<String> expectedResult = List.of(expectedFirstName, expectedSecondName);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyTotalPriceTest(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.addSauceLabsBikeLight();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        Assert.assertEquals(checkoutOverviewPage.sumOfTwoProducts(), checkoutOverviewPage.totalSum());
    }

    @Test
    public void verifyOrderOfSeveralProductsTest(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addSauceLabsBackpack();
        productsPage.addSauceLabsBikeLight();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }
}
