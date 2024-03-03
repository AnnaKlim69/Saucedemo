package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class BackHome extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='title' and text()='%s']";
    protected static final Button BACKHOME_BUTTON = new Button(By.xpath("//button[@class='btn btn_primary btn_small' and text()='Back Home']"));
    public BackHome() {
        super(By.xpath(PAGE_LOCATOR), "'Back Home' Page");
    }
    public void clickBackHome() {
        BACKHOME_BUTTON.click();
    }
}