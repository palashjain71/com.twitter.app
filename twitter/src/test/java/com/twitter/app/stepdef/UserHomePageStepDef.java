package com.twitter.app.stepdef;

import com.twitter.app.pages.HomePage;
import com.twitter.app.pages.UserHomePage;
import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserHomePageStepDef {

    UserHomePage homePage = new UserHomePage(DriverUtils.driver);

    @Then("I verify home page heading on user home page")
    public void i_verify_to_user_twitter_homePage() {
        homePage.isRedirect();
        homePage.verifyHomePageSpanPresent();
    }

    @Then("I search for account {string} on user home page")
    public void i_verify_to_user_twitter_homePage(String account) {
        homePage.searchFeedForAcoount(account);
    }

    @Then("I click on latest feed on user home page")
    public void i_click_latest_feed() {
        homePage.clickOnLatest();
    }

    @Then("I print latest feed from home page")
    public void print_latest_feed() {
        homePage.fetchLatestTweetDetails();
    }


    @Then("I click on profile link on user home page")
    public void i_click_on_profile_btn() {
        homePage.clickOnProfileButton();
    }


}
