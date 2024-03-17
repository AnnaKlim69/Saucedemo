package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

import java.util.Objects;

import static framework.Browser.getDriver;

public class CartPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Your Cart']";
    private static final String CART_ITEM = "//div[@class='inventory_item_name' and  text()='%s']";
    private static final String CART_PRICE = "//div[@class='inventory_item_price']";
    protected static final Button CHECKOUT_BUTTON = new Button(By.xpath("//button[@id='checkout']"));

    private String productItem;
    public static double price;

    public CartPage() {
        super(By.xpath(PAGE_LOCATOR), "Cart Page");
    }

    public String getProductItem() {
        return productItem = CART_ITEM;
    }

    public double getCartProductPrice() {
        return price = Double.parseDouble(getDriver().findElement(By.xpath(String.format(CART_PRICE, productItem)))
                .getText().replace("$", ""));
    }

    public void itemValidation() {
        if (productItem.equals(ProductsPage.productName)) {
            System.out.println("Items are equal");
        } else {
            System.out.println("Items are not equal");
        }
    }

    public void itemPriceCartValidation() {
        if (!Objects.equals(getCartProductPrice(), SingleProductPage.price)) {
            System.out.println("Items are not equal");
        } else {
            System.out.println("Items are equal");
        }
    }

    public void clickCheckOutCartButton() {
        CHECKOUT_BUTTON.click();
    }
}