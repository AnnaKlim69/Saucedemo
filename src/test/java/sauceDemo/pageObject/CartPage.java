package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class CartPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Your Cart']";
    private static final List<String> PRODUCTS_LIST = getDriver().findElements(By.xpath("//div[@class='inventory_list']//a/div"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String CART_ITEM = "//div[@class='inventory_item_name' and  text()='%s']";
    private static final String CART_PRICE = "//div[@class='inventory_item_price']";
    private static final Button REMOVE_CART_BUTTON = new Button(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
    protected static final Button CHECKOUT_BUTTON = new Button(By.xpath("//button[@id='checkout']"));
    protected static final Button CONTINUE_SHOPPING_BUTTON = new Button(By.xpath("//button[@id='continue-shopping']"));
    protected static final Button CART_BUTTON = new Button(By.xpath("//a[@class='shopping_cart_link']"));

    private WebElement cartItem;
    public static String cartProductName;
    public static double cartPrice;
    public String productCartItem;

    public CartPage() {
        super(By.xpath(PAGE_LOCATOR), "Cart Page");
    }

    public WebElement cartProductSelection() {
        Random random = new Random();
        int r = random.nextInt(1, PRODUCTS_LIST.size());
        int i = r - 1;
        cartProductName = PRODUCTS_LIST.get(i);
        System.out.println(cartProductName);
        return cartItem = getDriver().findElement(By.xpath(String.format(CART_ITEM, cartProductName)));
    }
    public void clickOnProductCartName() {
        cartProductSelection();
        cartItem.click();
    }
    public String getProductCartItem() {
        return productCartItem = CART_ITEM;
    }
    public void itemProductCartValidation() {
        if (getProductCartItem().equals(ProductsPage.productName)) {
            System.out.println("Items are equal");
        } else {
            System.out.println("Items are not equal");
        }
    }
    public double getProductCartPrice() {
        return cartPrice = Double.parseDouble(getDriver().findElement(By.xpath(String.format(CART_PRICE, cartProductName)))
                .getText().replace("$", ""));
    }

    public void itemPriceCartValidation() {
        if (!Objects.equals(getProductCartPrice(), ProductsPage.price)) {
            System.out.println("Items are not equal");
        } else {
            System.out.println("Items are equal");
        }
    }

    public void clickRemoveFromCartButton() {
        cartProductSelection();
        REMOVE_CART_BUTTON.click();
    }

    public void clickCheckOutCartButton() {//нажатие кнопки
        CHECKOUT_BUTTON.clickAndWait();
    }

    public void clickContinueShoppingCartButton() {
        CONTINUE_SHOPPING_BUTTON.clickAndWait();
    }

    public void clickCartButton() {
        CART_BUTTON.clickAndWait();
    }
}