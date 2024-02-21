package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class CheckOutPage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='title' and text()='Checkout: Your Information']";//страница с паролем
    private static final TextBox FIRST_NAME = new TextBox(By.xpath("//input[@id='user-name']"));// поле имени пользователя
    private static final TextBox LAST_NAME = new TextBox(By.xpath("//input[@id='password']"));//поле пароля
    protected static final TextBox ZIP_POSTAL_CODE = new TextBox(By.xpath("//input[@id='login-button']"));//кнопка авторизации
    protected static final Button CANCEL_BUTTON = new Button(By.xpath("//input[@id='login-button']"));
    protected static final Button CONTINUE_BUTTON = new Button(By.xpath("//input[@id='login-button']"));
    protected static final Button CART_BUTTON = new Button(By.xpath("//a[@class='shopping_cart_link']"));

    public CheckOutPage() {
        super(By.xpath(PAGE_LOCATOR), "Check Out Page");//название страницы (класса)
    }
    private void setFirstName(String firstName) {FIRST_NAME.sendKeys(firstName);
    }

    private void setLastName(String lastName) {LAST_NAME.sendKeys(lastName);
    }
    private void setZip_Postal_Code(String zip_Postal_Code) {ZIP_POSTAL_CODE.sendKeys(zip_Postal_Code);
    }
    private void clickConcelButton() {//нажатие кнопки
        CANCEL_BUTTON.clickAndWait();
    }

    private void clickContinueButton() {//нажатие кнопки
        CONTINUE_BUTTON.clickAndWait();
    }

    private void clickCartButton() {//нажатие кнопки
        CART_BUTTON.clickAndWait();
    }
    public void fillIntCheckoutYourInformation(String firstName, String lastName, String zip_Postal_Code) {
        setFirstName(firstName);
        setLastName(lastName);
        setZip_Postal_Code(zip_Postal_Code);
        clickConcelButton();
        clickContinueButton();
        clickCartButton();
    }

}
