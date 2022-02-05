package com.twitter.app.pages;

import com.twitter.app.utilities.BrowserHandles;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class UserHomePage {
    WebDriver driver;
    BrowserHandles browserHanldles;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
        browserHanldles = new BrowserHandles(this.driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Home']")
    private WebElement homePageSpan;

    @FindBy(xpath = "//a[@aria-label='Profile']")
    private WebElement buttonProfile;

    public void isRedirect() {
        browserHanldles.isElementDisplayed(homePageSpan);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("/home"));
    }

    public void verifyHomePageSpanPresent() {
        browserHanldles.isElementDisplayed(homePageSpan);
    }

    public void clickOnProfileButton() {
        browserHanldles.isElementDisplayed(buttonProfile);
        browserHanldles.jsClick(buttonProfile);
    }


    @FindBy(xpath = "//input[@data-testid='SearchBox_Search_Input']")
    private WebElement searchBar;


    public void searchFeedForAcoount(String account) {
        browserHanldles.isElementDisplayed(searchBar);
        browserHanldles.click(searchBar);
        browserHanldles.sendKeys(searchBar, account);
        searchBar.sendKeys(Keys.ENTER);
    }


    @FindBy(xpath = "//span[text()='Latest']")
    private WebElement latestFeed;

    public void clickOnLatest() {
        browserHanldles.isElementDisplayed(latestFeed);
        browserHanldles.click(latestFeed);
    }

    @FindBy(xpath = "//time")
    private List<WebElement> getLatestFeedTime;


    @FindBy(xpath = "(//article[@data-testid='tweet'])[1]")
    private WebElement tweets;


    public void fetchLatestTweetDetails() {
        browserHanldles.waitTillUrl("f=live");
        browserHanldles.isElementDisplayed(tweets);
        Date tweetDate;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        List<WebElement> ele = driver.findElements(By.xpath("//time/ancestor::div/following-sibling::div//div[starts-with(@id,'id_')][@lang]"));

        for (int i = 0; i < ele.size(); i++) {
            try {
                Date presentTime = sdf.parse(sdf.format(date));
                tweetDate = sdf.parse(getLatestFeedTime.get(i).getAttribute("datetime"));
                System.out.println(i + "tweet --> " + tweetDate);
                long differenceInHours = ((presentTime.getTime() - tweetDate.getTime()) / (1000 * 60 * 60)) % 24;
                if (differenceInHours < 2) {
                    System.out.println(ele.get(i).getText());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }


    }

}



