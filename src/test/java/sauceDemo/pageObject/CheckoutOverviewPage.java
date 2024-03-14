package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {
    private static final String PAGE_LOCATOR =
            "//span[@class='title' and text()='%s']";
    private static final String PRODUCT_PRICE = "//a/div[text()='%s']/../../..//div[@class='inventory_item_price']";
    private static final String PRODUCT_ITEM = "//div[@class='inventory_details_name large_size']";
    protected static final Button FINISH_BUTTON = new Button(By.xpath(
            "//button[@class='btn btn_action btn_medium cart_button' and text()='Finish']"));
    public String productItem;
    public static double price;

    public CheckoutOverviewPage() {
        super(By.xpath(PAGE_LOCATOR), "Single Product Page");
    }

    public void clickFinishButton() { FINISH_BUTTON.click();
    }
}