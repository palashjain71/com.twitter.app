package com.twitter.app.stepdef;

import com.twitter.app.pages.HomePage;
import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {

    HomePage homePage = new HomePage(DriverUtils.driver);

    @When("I navigate to twitter webiste homepage")
    public void i_navigate_to_twitter_homePage(){
    homePage.isRedirect();
    }

    @Then("I click on signin on homepage")
    public void i_click_on_signin_homePage(){
        homePage.verifySigninBtnPresent();
        homePage.clickOnSigninBtn();
    }







}
