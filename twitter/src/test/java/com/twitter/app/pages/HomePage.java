package com.twitter.app.pages;

import com.twitter.app.utilities.BrowserHandles;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    BrowserHandles browserHanldles;

    public HomePage(WebDriver driver){
        this.driver = driver;
        browserHanldles = new BrowserHandles(this.driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement signInBtn;

    public void isRedirect(){
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("twitter.com"));
    }

    public void verifySigninBtnPresent(){
        browserHanldles.isElementDisplayed(signInBtn);
    }

    public void clickOnSigninBtn(){
        browserHanldles.jsClick(signInBtn);
    }





}
