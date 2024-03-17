package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

import java.util.Objects;

import static framework.Browser.getDriver;

public class SingleProductPage extends BasePage {
    private static final String PAGE_LOCATOR =
            "//div[@class='inventory_details_name large_size' and text()='%s']";
    private static final String PRODUCT_PRICE = "//div[@class='inventory_details_price']";
    private static final String PRODUCT_ITEM = "//div[@class='inventory_details_name large_size']";
    private static final Button ADD_TO_CART_BUTTON = new Button(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory' and text()='Add to cart']"));
    protected static final Button CART_BUTTON = new Button(By.xpath("//a[@class='shopping_cart_link']"));
    public static String productItem;
    public static String productName;
    public static double price;

    public SingleProductPage() {super(By.xpath(PAGE_LOCATOR), "Single Product Page");
    }

    public String getProductItem() {
        return productItem = PRODUCT_ITEM;
    }

    public double getSingleProductPrice() {
        return price = Double.parseDouble(getDriver().findElement(By.xpath(String.format(PRODUCT_PRICE, productName)))
                .getText().replace("$", ""));
    }

    public void itemValidation() {
        if (productItem.equals(ProductsPage.productName)) {
            System.out.println("Items are equal");
        } else {
            System.out.println("Items are not equal");
        }
    }

    public void itemPriceValidation() {
        if (!Objects.equals(price, ProductsPage.price)) {
            System.out.println("Items are not equal");
        } else {
            System.out.println("Items are equal");
        }
    }

    public void clickAddToCartButton() {
        ADD_TO_CART_BUTTON.click();
    }

    public void clickCartButton() {
        CART_BUTTON.click();
    }
}