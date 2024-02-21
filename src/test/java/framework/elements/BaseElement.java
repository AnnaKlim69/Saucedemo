package framework.elements;

import framework.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.Browser.getDriver;
import static framework.Browser.waitForPageLoad;
import static framework.PropertyReader.getIntProperty;

public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    protected By by;
    private String name;
    private WebDriverWait wait;
    private int invaLidImageCount = 0;

    List<String> broKenImgList = new ArrayList<>();

    public static String getLoc(final String key) {//получить лок???
        return getProperty(key);
    }

    public WebElement getElement() {
        isElementPresent();
        return element;
    }

    public BaseElement(By by) {//Базовый элемент
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected abstract String getElementType();

    public boolean waitForIsElementPressent() {
        return isElementPresent();
    }

    public boolean waitForIsElementsArePressent() {
        waitForIsElementPressent();
        return false;
    }

    public List<WebElement> getElements() {
        isElementPresent();
        return elements;
    }

    protected List<? extends BaseElement> returnElements;

    public boolean isElementPresent() {
        try {
            getDriver().manage().timeouts().implicitlyWait(new PropertyReader("config.properties").
                    getIntProperty("timeout"), TimeUnit.SECONDS);
            element = getDriver().findElement(by);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(getElementType() + ":" + by + "is not present. Exception - " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static String getProperty(String key) {//получить свойство
        return key;
    }

    public boolean isElementClickable() {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(getIntProperty("element.timeout")))
                    .until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable" + getElementType() + by);
            return false;
        }
    }

    public String sendKeys(String senKeys) {
        isElementPresent();
        getElement().sendKeys(senKeys);
        return senKeys;
    }

    public boolean isSelected() {
        isElementPresent();
        System.out.println((getProperty("log.select") + getElement().getText()));
        return getElement().isSelected();
    }

    public boolean isDisplayed() {
        isElementPresent();
        if (getElement().isDisplayed()) {
            System.out.println(getElementType() + ":" + by + "is displeted");
            return true;
        } else {
            System.out.println(getElementType() + ":" + by + "is not displeted");
            return false;
        }
    }

    public void click() {
        isElementPresent();
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid orange'", getElement());
            isElementClickable();
            getElement().click();
        }
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void clickAndWait() {
        isElementPresent();
        getElement().click();
        waitForPageLoad();
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void clickViaJS() {
        isElementPresent();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getElement());
    }

    public void scrollIntoView() {
        isElementPresent();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    public void moveAndClickByActions() {
        // и выполнения клика на этом элементе
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement()).click().build().perform();
    }

    public void moveByActions() {
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement()).moveByOffset(getIntProperty("x"), getIntProperty("y")).perform();
    }

    public void moveToElement() {
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement()).perform();
        getElement().click();
    }

    public String getAttribute(String attribute) {
        isElementPresent();
        return getElement().getAttribute(attribute);
    }

    public String getText() {
        isElementPresent();
        System.out.println(getElement().getText());
        return getElement().getText();
    }
}