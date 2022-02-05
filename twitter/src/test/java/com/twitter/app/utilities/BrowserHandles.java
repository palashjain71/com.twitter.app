package com.twitter.app.utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserHandles {
    WebDriver driver;
    int shortTimeOut = 15;
    int defaultTimeOut = 5;

    public BrowserHandles(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return new WebDriverWait(driver, shortTimeOut).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitTillUrl(String url) {
        try {
            return new WebDriverWait(driver, shortTimeOut).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void jsClick(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style' , 'background: yellow; border: 2px solid red;');", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to click " + e.getMessage());
        }
    }

    public void scrolltoView(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find Element " + e.getMessage());
        }
    }

    public void jsSendKeys(WebElement element, String content) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + content + "';", element);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find Element " + e.getMessage());
        }
    }

    public void moveToElement(WebElement element) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception e) {
            throw new RuntimeException("Unable to find Element " + e.getMessage());
        }
    }


    public void sendKeys(WebElement element, String content) {
        try {
            element.clear();
            element.sendKeys(content);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find Element " + e.getMessage());
        }
    }

    public void click(WebElement element) {
        element.click();
    }


}
