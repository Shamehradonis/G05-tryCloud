package com.tryCloud.step_definitions;

import com.tryCloud.pages.DashboardFunctionalityPage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DashboardFunctionality_StepDefs {


    DashboardFunctionalityPage dashboardPage = new DashboardFunctionalityPage();;
    LoginPage loginPage;



    @Then("User should be able to see all modules below")
    public void user_should_be_able_to_see_all_modules_below(List<String> expectedModules) {

        System.out.println("expectedModules = " + expectedModules);
        BrowserUtils.sleep(2);

        List<String> actualModules = BrowserUtils.getElementsText(dashboardPage.moduleElements);
        System.out.println("actualModules = " + actualModules);
        Assert.assertEquals(expectedModules, actualModules);


    }

    @Then("User should be able to see the username {string}")
    public void user_should_be_able_to_see_the_username(String expectedUsername) {

        dashboardPage = new DashboardFunctionalityPage();

        dashboardPage.profileBotton.click();
        String actualUsername = dashboardPage.username.getText();


    }

    @When("User clicks on customize button")
    public void userClicksOnCustomizeButton() {
        dashboardPage.customizeButton.click();

    }

    @Then("User should see the following widgets")
    public void userShouldSeeTheFollowingWidgets(List<String> expectedWidgets) {

       // dashboardPage = new DashboardFunctionalityPage();

       // List<String> actualWidgets = dashboardPage.getWidgetsNames();
        //Assert.assertEquals(actualWidgets, expectedWidgets);
    }

    @When("User selects the {string} widget checkbox")
    public void userSelectsTheWidgetCheckbox(String arg0) {

    }

    @Then("The {string} widget should be checked")
    public void theWidgetShouldBeChecked(String arg0) {

    }






    @And("User can see background images and select any of them")
    public void userCanSeeBackgroundImagesAndSelectAnyOfThem() {
    }


    @When("User clicks on Set Status button")
    public void user_can_click_on_set_status_button() {

        dashboardPage.setStatusButton.click();



    }



    @Then("User sees Online status options and select any of them")
    public void user_sees_online_status_options_and_select_any_of_them(List<String> expectedStatus) {
        dashboardPage = new DashboardFunctionalityPage();

        List<String> actualStatus = dashboardPage.getStatus();
        Assert.assertEquals(expectedStatus, actualStatus);

    }




    @Then ("User sees Status messages and select any of them")
    public void user_sees_status_messages_and_select_any_of_them(List<String> expectedStatusMessages) {
        dashboardPage = new DashboardFunctionalityPage();

        List<String> actualStatus = dashboardPage.getStatusMessages();
        Assert.assertEquals(expectedStatusMessages, actualStatus);

    }




    @Then("User can Set or Clear status messages")
    public void user_can_set_or_clear_status_messages() {
        dashboardPage.clearStatusButton.click();
        dashboardPage.clearStatusButton.isSelected();
        dashboardPage.setStatusBotton.click();
        dashboardPage.setStatusBotton.isSelected();


    }



}
