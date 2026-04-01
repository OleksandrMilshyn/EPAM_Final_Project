package finalProject.tests;

import finalProject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest{

    String expectedFirstName = "Sauce Labs Backpack";
    String expectedSecondName = "Sauce Labs Bike Light";
    String myFirstName = "OLEKSANDR";
    String myLastName = "MILSHYN";
    String myPostCode = "91-402";
    String expectedFinalText = "Thank you for your order!";

    @Test
    public void verifyProductPresentInCart(){

        login();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getFirstProductName();
        Assert.assertEquals(actualName, expectedFirstName);
    }

    @Test
    public void verifyOrderOfProduct(){

        login();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }

    @Test
    public void verifySeveralProductsInCart(){

        login();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        String actualName = cartPage.getFirstProductName();
        String actualName2 = cartPage.getSecondProductName();
        Assert.assertEquals(actualName, expectedFirstName);
        Assert.assertEquals(actualName2, expectedSecondName);
    }

    @Test
    public void verifyTotalPrice(){

        login();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.sumOfTwoProducts(), checkoutOverviewPage.totalSum());
    }

    @Test
    public void verifyOrderOfSeveralProducts(){

        login();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addTheFirstProduct();
        productsPage.addTheSecondProduct();
        productsPage.toCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillAllFields(myFirstName, myLastName, myPostCode);
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualFinalText = checkoutCompletePage.getCompleteOrderText();
        Assert.assertEquals(actualFinalText, expectedFinalText);
    }
}
