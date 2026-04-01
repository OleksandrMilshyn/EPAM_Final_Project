package finalProject.tests;

import finalProject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest{

    String login = ConfigReader.get("login");
    String password = ConfigReader.get("password");
    String expectedFirstName = "Sauce Labs Backpack";
    String expecteSeconddName = "Sauce Labs Bike Light";
    String myFirstName = "OLEKSANDR";
    String myLastName = "MILSHYN";
    String myPostCode = "91-402";
    String expectedFinalText = "Thank you for your order!";

    @Test
    public void verifyOrderOfProduct(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(login, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getFirstProductName();
        Assert.assertEquals(actualName, expectedFirstName);
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.addFirstName(myFirstName);
        checkoutInformationPage.addLastName(myLastName);
        checkoutInformationPage.addPostCode(myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }

    @Test
    public void verifyAddSeveralProducts(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(login, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getFirstProductName();
        String actualName2 = cartPage.getSecondProductName();
        Assert.assertEquals(actualName, expectedFirstName);
        Assert.assertEquals(actualName2, expecteSeconddName);
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.addFirstName(myFirstName);
        checkoutInformationPage.addLastName(myLastName);
        checkoutInformationPage.addPostCode(myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.sumOfTwoProducts(), checkoutOverviewPage.totalSum());
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }
}
