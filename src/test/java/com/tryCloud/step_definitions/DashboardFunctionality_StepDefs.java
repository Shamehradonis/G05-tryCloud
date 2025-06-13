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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DashboardFunctionality_StepDefs {


    DashboardFunctionalityPage dashboardPage = new DashboardFunctionalityPage();
    ;
    LoginPage loginPage;


    @Then("User should be able to see all modules below")
    public void user_should_be_able_to_see_all_modules_below(List<String> expectedModules) {

        System.out.println("expectedModules = " + expectedModules);
        BrowserUtils.sleep(2);

        List<String> actualModules = dashboardPage.getModulesNames();
        System.out.println("actualModules = " + actualModules);
        Assert.assertEquals(expectedModules, actualModules);


    }

    @Then("User should be able to see the username {string}")
    public void user_should_be_able_to_see_the_username(String expectedUsername) {

        dashboardPage = new DashboardFunctionalityPage();

        dashboardPage.profileBotton.click();
        String actualUsername = dashboardPage.username.getText();
        System.out.println("actualUsername = " + actualUsername);
        System.out.println("expectedUsername = " + expectedUsername);
        Assert.assertEquals(actualUsername, expectedUsername);


    }

    //****************************************************

    @When("User clicks on customize button")
    public void userClicksOnCustomizeButton() {
        dashboardPage.customizeButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("User should see the following widgets")
    public void userShouldSeeTheFollowingWidgets(List<String> expectedWidgets) {

        dashboardPage = new DashboardFunctionalityPage();


        List<String> actualWidgets = new ArrayList<>();

        for(WebElement each : dashboardPage.widgets ){
            actualWidgets.add(each.getText().trim());
        }

        System.out.println("actualWidgets   = " + actualWidgets);
        System.out.println("expectedWidgets = " + expectedWidgets);

        Assert.assertTrue(actualWidgets.containsAll(expectedWidgets));
                BrowserUtils.sleep(1);
    }

    @And("User should see following widgetsName")
    public void User_should_see_following_widgetsName(String widget) {
        Driver.getDriver().findElement(By.xpath("//label[normalize-space(text())='"+widget+"']"
        )).click();
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(3);

    }


    @Then("User can see background images")
    public void user_can_see_background_images() {

    }

    @Then("User select any of background images")
    public void user_select_any_of_background_images() {


    }

    //********************************************************

    @When("User click on Set Status button")
    public void user_can_click_on_set_status_button() {
        dashboardPage.setStatusButton.click();
    }

    @Then("User sees {string} options and select any of them")
    public void user_sees_options_and_select_any_of_them(List<String> expectedOnlineStatus) {
        dashboardPage = new DashboardFunctionalityPage();

        List<String> actualOnlineStatus = dashboardPage.getStatus();
        Assert.assertEquals(expectedOnlineStatus, actualOnlineStatus);


    }

    @Then("User sees {string} and select any of the them")
    public void user_sees_and_select_any_of_the_them(List<String> expectedStatusMessages) {

        dashboardPage = new DashboardFunctionalityPage();

        List<String> actualStatus = dashboardPage.getStatusMessages();
        Assert.assertEquals(expectedStatusMessages, actualStatus);
    }

    @Then("User can Set or Clear {string}")
    public void user_can_set_or_clear() {


        dashboardPage.clearStatusButton.click();
        dashboardPage.clearStatusButton.isSelected();
        dashboardPage.setStatusBotton.click();
        dashboardPage.setStatusBotton.isSelected();
    }

    @Then("After these steps user see his/her selections on dashboard")
    public void after_these_steps_user_see_his_her_selections_on_dashboard() {



    }

}