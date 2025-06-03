package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginPage_StepDefs {
LoginPage loginPage=new LoginPage();
BasePage basePage = new BasePage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("the user enters valid {string} and {string} with {string}")
    public void the_user_enters_valid_and_with(String username, String password, String submitType) {
     loginPage.login(username,password,submitType);
        BrowserUtils.sleep(3);
    }
    @Then("the user should see the url contains {string}")
    public void the_user_should_see_the_url_contains(String url) {
     BrowserUtils.verifyURLContains(url);
    }
    @Then("the user should see the username as {string}")
    public void the_user_should_see_the_username_as(String expectedUser) {
        basePage.account.click();
    String actualUsername = basePage.userStatus.getText();
      Assert.assertEquals(actualUsername,expectedUser);
    }

}
