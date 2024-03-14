package sauceDemo.tests;

import framework.BaseTest;
import framework.PropertyReader;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import sauceDemo.pageObject.*;

public class E2ETest extends BaseTest {
    @Test
    @Description("test desc")
    public void e2eTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInLoginForm(PropertyReader.getProperty("userName"), PropertyReader.getProperty("password"));
        loginPage.clickLoginButton();

        ProductsPage productPage = new ProductsPage();
        productPage.productSelection();
        productPage.clickOnProductName();

        SingleProductPage singleProductPage = new SingleProductPage();
        singleProductPage.clickAddToCartButton();
        singleProductPage.clickCartButton();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckOutCartButton();

        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
        checkoutYourInformationPage.fillIntCheckoutYourInformation(PropertyReader.getProperty("firstName"),
                PropertyReader.getProperty("lastName"), PropertyReader.getProperty("zip_Postal_Code"));
        checkoutYourInformationPage.clickContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickFinishButton();

        BackHome backHome = new BackHome();
        backHome.clickBackHome();

        productPage.productSelection();
    }
}