package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_StepDefs {
    LoginPage loginPage;
    BasePage basePage = new BasePage();
    @Given("user logged in")
    public void user_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage=new LoginPage();
        loginPage.login();
    }
    @When("user click on account button")
    public void user_click_on_account_button() {
        basePage.account.click();
    }
    @When("user click the logout button")
    public void user_click_the_logout_button() {
        basePage.logoutButton.click();
    }
    @Then("user should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page() {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("url"));
    }
    @And("user click on step back button")
    public void userClickOnStepBackButton() {
        Driver.getDriver().navigate().back();
    }
    @Then("user still in logging page")
    public void userStillInLoggingPage() {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("url"));
    }


    @When("user does not do any mouse or keyboard action for {int} minutes")
    public void userDoesNotDoAnyMouseOrKeyboardActionForMinutes(int time) {
        int minToSec = time*60+10;
        BrowserUtils.sleep(minToSec);
    }

    @Then("user must be logged out")
    public void userMustBeLoggedOut() {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("url"));
    }
}
