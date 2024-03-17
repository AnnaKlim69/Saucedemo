package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class ProductsPage extends BasePage {
    private static final String PAGE_LOCATOR = "//span[@class='title']";
    private static final List<String> PRODUCTS_LIST = getDriver().findElements(By.xpath
                    ("//div[@class='inventory_list']//a/div")).stream().map(e -> e.getText())
            .collect(Collectors.toList());
    private static final String ITEM = "//div[@class='inventory_item_name ' and  text()='%s']";
    private static final String PRICE = "//a/div[text()='%s']/../../..//div[@class='inventory_item_price']";
    private static final Button ADD_TO_CART_BUTTON = new Button(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    private static final Button REMOVE_CART_BUTTON = new Button(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
    protected static final Button CART_BUTTON = new Button(By.xpath("//a[@class='shopping_cart_link']"));

    private WebElement productItem;
    public static String productName;
    public static double price;

    public ProductsPage() {
        super(By.xpath(PAGE_LOCATOR), "'Products' Page");
    }

    public WebElement productSelection() {
        Random random = new Random();
        int r = random.nextInt(1, PRODUCTS_LIST.size());
        int i = r - 1;
        productName = PRODUCTS_LIST.get(i);
        System.out.println(productName);
        return productItem = getDriver().findElement(By.xpath(String.format(ITEM, productName)));
    }

    public double getProductPrice() {
        return price = Double.parseDouble(getDriver().findElement(By.xpath(String.format(PRICE, productName)))
                .getText().replace("$", ""));
    }
    public void clickAddToCartButton() {
        productSelection();
        ADD_TO_CART_BUTTON.click();
    }
    public void setScrollProductName(){
        productSelection();
        setScrollProductName();
    }
    public void clickOnProductName() {
        productSelection();
        productItem.click();
    }

    public void clickRemoveFromCarButton() {
        productSelection();
        REMOVE_CART_BUTTON.click();
    }

    public void clickCartButton() {
        CART_BUTTON.click();
    }
}