package finalProject.tests;

import finalProject.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class OrderTest{

    String expectedFirstName = "Sauce Labs Backpack";
    String expectedSecondName = "Sauce Labs Bike Light";
    String myFirstName = "OLEKSANDR";
    String myLastName = "MILSHYN";
    String myPostCode = "00-444";
    String expectedFinalText = "Thank you for your order!";

    @BeforeMethod
    @Parameters("browser")
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
    public void verifyProductPresentInCart(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addTheFirstProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage();
        String actualName = cartPage.getFirstProductName();
        Assert.assertEquals(actualName, expectedFirstName);
    }

    @Test
    public void verifyOrderOfProduct(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addTheFirstProduct();
        productsPage.toCart();

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
    public void verifySeveralProductsInCart(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage();
        String actualFirstName = cartPage.getFirstProductName();
        String actualSecondName = cartPage.getSecondProductName();

        List<String> actualResult = List.of(actualFirstName, actualSecondName);
        List<String> expectedResult = List.of(expectedFirstName, expectedSecondName);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyTotalPrice(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        Assert.assertEquals(checkoutOverviewPage.sumOfTwoProducts(), checkoutOverviewPage.totalSum());
    }

    @Test
    public void verifyOrderOfSeveralProducts(){

        ProductsPage productsPage = new LoginPage()
                .loginAsDefaultUser();

        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

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
