package com.twitter.app.stepdef;

import com.twitter.app.pages.HomePage;
import com.twitter.app.pages.Login;
import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

    Login login = new Login(DriverUtils.driver);

    @When("I will enter {string} on login page")
    public void i_will_enter_username_on_login_page(String userName) {
        login.verifySigninTwitterTextPresent();
        login.isRedirect();
        login.enterUserName(userName);
    }

    @When("I will enter password {string} on login page")
    public void i_will_enter_password_on_login_page(String password) {
        login.verifyEnterPasswordTextPresent();
        login.isRedirect();
        login.enterPassword(password);
    }

    @Then("I will click on next button on login")
    public void i_click_on_next_btn() {
        login.clickOnNextBtn();
    }

    @Then("I will click on login button on login page")
    public void i_click_on_login_btn() {
        login.clickOnLoginBtn();
    }


}
