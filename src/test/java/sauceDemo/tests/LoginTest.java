package sauceDemo.tests;

import framework.BaseTest;
import framework.PropertyReader;
import org.testng.annotations.Test;
import sauceDemo.pageObject.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithCorrectUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInLoginForm(PropertyReader.getProperty("userName"), PropertyReader.getProperty("password"));
    }
}