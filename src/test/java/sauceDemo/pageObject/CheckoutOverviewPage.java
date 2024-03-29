package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

import java.util.Objects;

import static framework.Browser.getDriver;

public class CheckoutOverviewPage extends BasePage {
    private static final String PAGE_LOCATOR =
            "//span[@class='title' and text()='%s']";
    private static final String PRODUCT_PRICE = "//div[@class='inventory_item_price']";
    private static final String PRODUCT_ITEM = "//div[@class='inventory_details_name large_size']";
    protected static final Button FINISH_BUTTON = new Button(By.xpath(
            "//button[@class='btn btn_action btn_medium cart_button' and text()='Finish']"));
    public String productItem;
    public static String productName;
    public static double price;

    public CheckoutOverviewPage() {
        super(By.xpath(PAGE_LOCATOR), "Single Product Page");
    }

    public String getProductItem() {
        return productItem = PRODUCT_ITEM;
    }

    public double getCheckoutOverviewProductPrice() {
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
    public void clickFinishButton() { FINISH_BUTTON.click();
    }
}