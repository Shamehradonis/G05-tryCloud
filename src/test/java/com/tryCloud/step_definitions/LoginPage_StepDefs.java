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
import org.openqa.selenium.JavascriptExecutor;

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

    @When("the user is logged in {string} and {string} with {string}")
    public void theUserIsLoggedInAndWith(String username, String password, String submitType) {
        loginPage.login(username,password,submitType);
    }
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedError) {
String actualError = loginPage.wrongCredentialsMassage.getText();
Assert.assertEquals(actualError,expectedError);
    }

    @When("the user is logged in {string} and {string}")
    public void the_user_is_logged_in_and(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("the user should see the {string} if {string} is empty")
    public void the_user_should_see_the_if_is_empty(String massage, String anyField) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        if(anyField.equals("username")){
            String validationMessage = (String) js.executeScript(
                    "return arguments[0].validationMessage;", loginPage.usernameBox
            );
            Assert.assertEquals(validationMessage,massage);
        } else if (anyField.equals("password")){
            String validationMessage = (String) js.executeScript(
                    "return arguments[0].validationMessage;", loginPage.passwordBox
            );
            Assert.assertEquals(validationMessage,massage);
        }
    }

    @Then("the password should be masked by default")
    public void thePasswordShouldBeMaskedByDefault() {
        String typeAttribute = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals(typeAttribute,"password");
    }

    @Then("Password visibility toggle allows user to see password explicitly")
    public void passwordVisibilityToggleAllowsUserToSeePasswordExplicitly() {
        loginPage.passwordBox.sendKeys("Employee123");
        loginPage.passwordVisibilityToggle.click();
        String typeAttribute = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals(typeAttribute,"text");
    }
    @Then("the user should see the Forgot password? link.")
    public void the_user_should_see_the_forgot_password_link() {
        Assert.assertTrue(loginPage.forgetPasswordLink.isDisplayed());
    }
    @When("the user click on the Forgot password? link.")
    public void the_user_click_on_the_forgot_password_link() {
        loginPage.forgetPasswordLink.click();
    }
    @When("Wait for the password reset page to load.")
    public void wait_for_the_password_reset_page_to_load() {
    BrowserUtils.waitFor(2);
    }
    @Then("The user should see the Reset Password button")
    public void the_user_should_see_the_reset_password_button() {

        Assert.assertTrue(loginPage.resetPasswordButton.isDisplayed());
    }
    @Then("the username field should have placeholder {string}")
    public void the_username_field_should_have_placeholder(String expectedPlaceholder1) {
        String actualPlaceholder = loginPage.usernameBox.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholder,expectedPlaceholder1);
    }
    @Then("the password field should have placeholder {string}")
    public void the_password_field_should_have_placeholder(String expectedPlaceholder2) {
        String actualPlaceholder = loginPage.passwordBox.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholder,expectedPlaceholder2);
    }
}
