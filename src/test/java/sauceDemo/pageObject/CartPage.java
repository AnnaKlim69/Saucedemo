package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class CartPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Your Cart']";
    private static final List<String> PRODUCTS_LIST = getDriver().findElements(By.xpath("//div[@class='inventory_list']//a/div"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String CART_ITEM = "//div[@class='inventory_item_name' and  text()='%s']";
    private static final String CART_PRICE = "//div[@class='inventory_item_price']";
    protected static final Button CHECKOUT_BUTTON = new Button(By.xpath("//button[@id='checkout']"));

    private WebElement cartItem;
    public static String cartProductName;
    public static double cartPrice;
    public String productCartItem;

    public CartPage() {
        super(By.xpath(PAGE_LOCATOR), "Cart Page");
    }


//    public double getProductCartPrice() {
//        return cartPrice = Double.parseDouble(getDriver().findElement(By.xpath(String.format(CART_PRICE, cartProductName)))
//                .getText().replace("$", ""));
//    }

//    public void itemPriceCartValidation() {
//        if (!Objects.equals(getProductCartPrice(), ProductsPage.price)) {
//            System.out.println("Items are not equal");
//        } else {
//            System.out.println("Items are equal");
//        }
//    }

    public void clickCheckOutCartButton() {
        CHECKOUT_BUTTON.click();
    }
}