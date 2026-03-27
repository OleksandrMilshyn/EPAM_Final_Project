package finalProject.tests;

import finalProject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest{

    String login = "standard_user";
    String password = "secret_sauce";
    String expectedName = "Sauce Labs Backpack";
    String expectedName2 = "Sauce Labs Bike Light";
    String myFirstName = "OLEKSANDR";
    String myLastName = "MILSHYN";
    String myPostCode = "91-402";
    String expectedFinalText = "Thank you for your order!";

    @Test
    public void verifyOrderOfProduct(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.userName(login);
        loginPage.userPassword(password);
        loginPage.logIn();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getProductName();
        Assert.assertEquals(actualName, expectedName);
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
        loginPage.userName(login);
        loginPage.userPassword(password);
        loginPage.logIn();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getProductName();
        String actualName2 = cartPage.getProductName2();
        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualName2, expectedName2);
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
