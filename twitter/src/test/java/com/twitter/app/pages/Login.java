package com.twitter.app.pages;

import com.twitter.app.utilities.BrowserHandles;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    BrowserHandles browserHanldles;

    public Login(WebDriver driver) {
        this.driver = driver;
        browserHanldles = new BrowserHandles(this.driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign in to Twitter')]")
    private WebElement signInTwitterText;

    @FindBy(xpath = "//span[contains(text(),'Enter your password')]")
    private WebElement enterPasswordText;

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@autocomplete='current-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//span[text()='Password']")
    private WebElement inputPasswordText;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextBtn;

    @FindBy(xpath = "//span[text()='Log in']")
    private WebElement loginBtn;



    public void isRedirect() {
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("/flow/login"));
    }

    public void verifySigninTwitterTextPresent() {
        browserHanldles.isElementDisplayed(signInTwitterText);
    }

    public void verifyEnterPasswordTextPresent() {
        browserHanldles.isElementDisplayed(enterPasswordText);
    }

    public void enterUserName(String userName) {
        browserHanldles.sendKeys(inputUserName, userName);
    }

    public void enterPassword(String password) {
       // browserHanldles.click(inputPasswordText);
        browserHanldles.isElementDisplayed(inputPassword);
        browserHanldles.sendKeys(inputPassword, password);
    }

    public void clickOnNextBtn() {
        browserHanldles.jsClick(nextBtn);
    }

    public void clickOnLoginBtn() {
        browserHanldles.jsClick(loginBtn);
    }

}
