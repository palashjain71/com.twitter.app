package com.twitter.app.stepdef;

import com.twitter.app.pages.ProfilePage;
import com.twitter.app.pages.UserHomePage;
import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProfilePageStepDef {

    ProfilePage profilePage = new ProfilePage(DriverUtils.driver);

    @Then("I verify profile home page open for {string}")
    public void i_verify_to_user_twitter_homePage(String username) {
        profilePage.isRedirect(username);
    }

    @Then("I click on set up profile on profile page")
    public void i_navigate_to_twitter_homePage() {
        profilePage.clickOnSetupProfile();
    }


    @Then("I click on Edit profile on profile page")
    public void i_click_edit_Profile() {
        profilePage.clickOnEditProfile();
    }

    @Then("I upload new profile pic on profile page")
    public void i_upload_profile() {
        profilePage.uploadProfilePicture();
    }


    @Then("I click on Apply button on profile page")
    public void i_click_apply_profile() {
        profilePage.clickApply();
    }

    @Then("I will click on next button on profile page")
    public void i_click_on_next_btn() {
        profilePage.clickNext();
    }



    @Then("I wait for pick a header heading and click skip on profile page")
    public void i_wait_header_pick_heading() {
        profilePage.clickSkipForNow();
    }

    @Then("I will update bio {string} on profile page")
    public void i_wait_update_bio(String bio) {
        profilePage.updateBio(bio);
    }

    @Then("I will update location {string} on profile page")
    public void i_wait_update_location(String location) {
        profilePage.updateLocation(location);
    }

    @Then("I verify details {string}, {string}, {string} updated are stored correctly on profile page")
    public void i_wait_update_location(String bio,String location,String website) {
        profilePage.verifyDetails(bio,location,website);
    }



    @Then("I will update website {string} on profile page")
    public void i_wait_update_website(String website) {
        profilePage.updateWebsite(website);
    }

    @Then("I will click on save button on profile page")
    public void i_click_save() {
        profilePage.clickSave();
    }

    @Then("I verify profile updated and click on see profile btn on profile page")
    public void i_wait_clickSeeProfile(String bio) {
        profilePage.clickSeeProfile();
    }


    @Then("I wait to Edit Profile on profile page")
    public void i_wait_pick_profile() {
        profilePage.verifytextEditProfileHeadingPresent();
    }


}
