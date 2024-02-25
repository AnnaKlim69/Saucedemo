package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class CheckoutYourInformationPage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='title' and text()='%s']";
    private static final TextBox FIRST_NAME = new TextBox(By.xpath("//input[@id='first-name']"));
    private static final TextBox LAST_NAME = new TextBox(By.xpath("//input[@id='last-name']"));
    protected static final TextBox ZIP_POSTAL_CODE = new TextBox(By.xpath("//input[@id='postal-code']"));
    protected static final Button CONTINUE_BUTTON = new Button(By.xpath("//input[@id='continue']"));

    public CheckoutYourInformationPage() {
        super(By.xpath(PAGE_LOCATOR), "'Checkout  Your Information' Page");
    }

    private void setFirstName(String firstName) {
        FIRST_NAME.sendKeys(firstName);
    }

    private void setLastName(String lastName) {
        LAST_NAME.sendKeys(lastName);
    }

    private void setZip_Postal_Code(String zip_Postal_Code) {
        ZIP_POSTAL_CODE.sendKeys(zip_Postal_Code);
    }

    public void clickContinueButton() {
        CONTINUE_BUTTON.click();
    }

    public void fillIntCheckoutYourInformation(String firstName, String lastName, String zip_Postal_Code) {
        setFirstName(firstName);
        setLastName(lastName);
        setZip_Postal_Code(zip_Postal_Code);
    }
}