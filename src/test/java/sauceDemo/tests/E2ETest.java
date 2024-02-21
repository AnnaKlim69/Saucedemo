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
        loginPage.fillIntLoginForm(PropertyReader.getProperty("userName"), PropertyReader.getProperty("password"));

        ProductsPage productPage = new ProductsPage();
        productPage.productSelection();
        productPage.clickAddToCartButton();
        productPage.clickRemoveFromCarButton();
        productPage.clickAddToCartButton();
        productPage.clickOnProductName();
        productPage.clickCartButton();

//        productPage.clickCartButton();
//        productPage.clickRemoveFromCarButton();
//        productPage.clickAddToCartButton();
//        productPage.clickCartButton();

//        SingleProductPage singleProductPage = new SingleProductPage();
//        singleProductPage.getProductItem();
//        singleProductPage.getSingleProductPrice();
//        singleProductPage.itemValidation();
//        singleProductPage.itemPriceValidation();
//        singleProductPage.clickAddToCartButton();
//        singleProductPage.isRemoveFromCarButton();
//        singleProductPage.clickCartButton();
//
//        CartPage cartPage = new CartPage();
//        cartPage.clickOnProductCartName();
//        cartPage.itemProductCartValidation();
//        cartPage.itemPriceCartValidation();
//        cartPage.clickRemoveFromCartButton();
//        cartPage.clickCheckOutCartButton();
//        cartPage.clickContinueShoppingCartButton();
//        cartPage.clickCartButton();
//
//        CheckOutPage checkOutPage = new CheckOutPage();
//        checkOutPage.fillIntCheckoutYourInformation(PropertyReader.getProperty("firstName"),
//                PropertyReader.getProperty("lastName"), PropertyReader.getProperty("zip_Postal_Code"));
    }
}