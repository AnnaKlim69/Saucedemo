package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {//!!!OK
    private static final String PAGE_LOCATOR = "//div[@class='login-box']";
    private static final TextBox USER_NAME = new TextBox(By.xpath("//input[@id='user-name']"));
    private static final TextBox PASSWORD = new TextBox(By.xpath("//input[@id='password']"));
    protected static final Button LOGIN_BUTTON = new Button(By.xpath("//input[@id='login-button']"));

    public LoginPage() {
        super(By.xpath(PAGE_LOCATOR), "Login Page");
    }

    private void setUserName(String userName) {//ввод имени пользователя
        USER_NAME.sendKeys(userName);
    }

    private void setPassword(String password) {//ввод пароля
        PASSWORD.sendKeys(password);
    }

    private void clickLoginButton() {//нажатие кнопки
        LOGIN_BUTTON.click();
    }

    @Step("Fill in login From with '{userName}', '{password}'")
    public void fillInLoginForm(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }
}