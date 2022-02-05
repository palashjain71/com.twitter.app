package com.twitter.app.pages;

import com.twitter.app.utilities.BrowserHandles;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.jws.soap.SOAPBinding;

public class ProfilePage {
    WebDriver driver;
    BrowserHandles browserHanldles;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        browserHanldles = new BrowserHandles(this.driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'photo')]")
    private WebElement profilePicPhoto;

    @FindBy(xpath = "//a[@href='/i/flow/setup_profile']")
    private WebElement buttonSetUpProfile;

    @FindBy(xpath = "//div[@aria-label='Add avatar photo']/following-sibling::input[@type='file'][@accept='image/jpeg,image/png,image/webp']")
    private WebElement buttonAddPhoto;

    @FindBy(xpath = "//span[contains(text(),'Pick a profile picture')]")
    private WebElement picProfilePicHeading;


    public void isRedirect(String username) {
        Assert.assertTrue(browserHanldles.isElementDisplayed(profilePicPhoto));
        Assert.assertTrue(driver.getCurrentUrl().contains(username));
         }

    public void verifyProfilePicPresent() {
        browserHanldles.isElementDisplayed(profilePicPhoto);
    }

    public void verifyPicProfileHeadingPresent() {
        browserHanldles.isElementDisplayed(picProfilePicHeading);
    }


    public void clickOnSetupProfile() {
        browserHanldles.isElementDisplayed(buttonSetUpProfile);
        browserHanldles.jsClick(buttonSetUpProfile);
    }

    @FindBy(xpath = "//a[@href='/settings/profile']")
    private WebElement buttonEditProfile;

    @FindBy(xpath = "//span[text()='Edit profile']")
    private WebElement textEditProfile;

    public void verifytextEditProfileHeadingPresent() {
        browserHanldles.isElementDisplayed(textEditProfile);
    }

    public void clickOnEditProfile() {

        browserHanldles.isElementDisplayed(buttonEditProfile);
        browserHanldles.jsClick(buttonEditProfile);
    }

    public void uploadProfilePicture() {
        browserHanldles.isElementDisplayed(textEditProfile);
        browserHanldles.moveToElement(buttonAddPhoto);
        browserHanldles.sendKeys(buttonAddPhoto, System.getProperty("user.dir") +"\\src\\test\\java\\com\\twitter\\app\\TestData\\Palash.jpg");
    }

    @FindBy(xpath = "//span[text()='Edit media']")
    private WebElement headingEditMedia;

    @FindBy(xpath = "//span[text()='Apply']")
    private WebElement applyBtn;

    public void clickApply(){
    browserHanldles.isElementDisplayed(headingEditMedia);
    browserHanldles.jsClick(applyBtn);
    }

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextBtn;

    public void clickNext(){
        browserHanldles.jsClick(nextBtn);
    }

    @FindBy(xpath = "//span[text()='Pick a header']")
    private WebElement headingPickHeader;

    @FindBy(xpath = "//span[text()='Skip for now']")
    private WebElement skipBtn;

    public void clickSkipForNow(){
        browserHanldles.isElementDisplayed(headingPickHeader);
        browserHanldles.jsClick(skipBtn);
    }


    @FindBy(xpath = "//span[text()='Describe yourself']")
    private WebElement headingBioHeader;

    @FindBy(xpath = "//textarea")
    private WebElement textAreaToUpdateBio;


    public void updateBio(String bio){
        browserHanldles.click(textAreaToUpdateBio);
        browserHanldles.sendKeys(textAreaToUpdateBio,bio);
        }

    @FindBy(xpath = "//input[@name='location']")
    private WebElement location;


    public void updateLocation(String locationValue){
        browserHanldles.click(location);
        browserHanldles.sendKeys(location,locationValue);
    }

    @FindBy(xpath = "//div[@data-testid='UserDescription']")
    private WebElement UserDescription;

    @FindBy(xpath = "//span[@data-testid='UserLocation']")
    private WebElement UserLocation;

    @FindBy(xpath = "//a[@data-testid='UserUrl']")
    private WebElement UserUrl;

    public void verifyDetails(String bio, String locationValue, String website) {
        browserHanldles.isElementDisplayed(UserDescription);
        Assert.assertTrue(UserDescription.getText().contains(bio));
        Assert.assertTrue(UserLocation.getText().contains(locationValue));
        Assert.assertTrue(UserUrl.getText().contains(website));
    }

    @FindBy(xpath = "//input[@name='url']")
    private WebElement website;

    public void updateWebsite(String url){
        browserHanldles.click(website);
        browserHanldles.sendKeys(website,url);
    }

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    public void clickSave(){
        browserHanldles.jsClick(save);
    }


    @FindBy(xpath = "//span[text()='Your profile is updated']")
    private WebElement headingProfileUpdatedHeader;

    @FindBy(xpath = "//span[text()='See profile']")
    private WebElement seeProfileBtn;


    public void clickSeeProfile(){
        browserHanldles.isElementDisplayed(headingProfileUpdatedHeader);
        browserHanldles.jsClick(seeProfileBtn);
    }



}

