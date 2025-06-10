package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.TalkModulePage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalkModule_StepDefs {
    BasePage basePage;
    TalkModulePage talkModulePage = new TalkModulePage();



    @Given("user clicks on Talk module")
    public void user_clicks_on_talk_module() {
        basePage=new BasePage();
        basePage.talkModule.click();
    }
    @When("the user clicks on Create a new group conversation")
    public void the_user_clicks_on_create_a_new_group_conversation() {
      talkModulePage.createNewConversationButton.click();
    }
    @When("enters a {string}")
    public void enters_a(String name) {
        talkModulePage.conversationNameBox.sendKeys(name);
    }
    @When("put the check on Allow quest to join via link")
    public void put_the_check_on_allow_quest_to_join_via_link() {
        talkModulePage.checkBox.click();
    }
    @When("clicks on Add participants")
    public void clicks_on_add_participants() {
        talkModulePage.addParticipantsButton.click();
    }
    @When("add at least one user like {string}")
    public void add_at_least_one_user_like(String user) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+user+"']")).click();
    }
    @When("click on Create conversation")
    public void click_on_create_conversation() {
        talkModulePage.createConversationButton.click();
        talkModulePage.closeButton.click();
        Driver.getDriver().navigate().refresh();
    }
    @Then("a new conversation {string} should appear in the conversation list")
    public void a_new_conversation_should_appear_in_the_conversation_list(String name) {
        List<String> conversionList = new ArrayList<>();
        for(WebElement each : talkModulePage.conversationList){
            conversionList.add(each.getText());
        }
        Assert.assertTrue(conversionList.contains(name));
    }


    @Given("the user selects any {string} from list")
    public void the_user_selects_any_from_list(String conversation) {
        Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='"+conversation+"']")).click();

    }
    @When("the user clicks on Add Participant to the conversation")
    public void the_user_clicks_on_add_participant_to_the_conversation() {
        talkModulePage.addParticipantBox.click();
        talkModulePage.addParticipantBox.sendKeys("E");
        BrowserUtils.sleep(1);

    }
    @When("selects a {string} from the contacts")
    public void selects_a_from_the_contacts(String userName) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+userName+"']")).click();
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(2);
    }
    @Then("the selected {string} should appear in the participant list")
    public void the_selected_should_appear_in_the_participant_list(String userName) {
        List<String> participantsList=new ArrayList<>();
        for(WebElement each : talkModulePage.participantsList){
            participantsList.add(each.getText());
        }
        Assert.assertTrue(participantsList.contains(userName));
    }
    @Then("the user should see a list of all their existing conversations")
    public void the_user_should_see_a_list_of_all_their_existing_conversations() {
        List<String> conversionList = new ArrayList<>();
        for(WebElement each : talkModulePage.conversationList){
            conversionList.add(each.getText());
        }
        Assert.assertTrue(!conversionList.isEmpty());
    }
    @When("the user clicks on the Start Call button")
    public void the_user_clicks_on_the_start_call_button() {
        BrowserUtils.sleep(2);
        talkModulePage.startCallButton.click();
        BrowserUtils.sleep(2);

    }
    @Then("a call window should open")
    public void a_call_window_should_open() {
        talkModulePage.conversationListButton.click();
        BrowserUtils.sleep(2);
        talkModulePage.youStartedACall.isDisplayed();
        BrowserUtils.sleep(2);
    }
    @When("the user clicks the Leave Call button")
    public void the_user_clicks_the_leave_call_button() {
        talkModulePage.leaveCallButton.click();
        BrowserUtils.sleep(2);
    }
    @Then("the call window should close")
    public void the_call_window_should_close() {
        talkModulePage.youLeftTheACall.isDisplayed();
        BrowserUtils.sleep(2);
    }
    @Given("the user clicks on three dots of any {string} from list")
    public void the_user_clicks_on_three_dots_of_any_from_list(String conversationName) {
        Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='"+conversationName+"']/following::button[1]")).click();
    }
    @When("clicks on Delete conversation from the option list")
    public void clicks_on_delete_conversation_from_the_option_list() {
        talkModulePage.deleteConversationButton.click();
    }
    @When("clicks on yes in confirmation massage for delete after that")
    public void clicks_on_yes_in_confirmation_massage_for_delete_after_that() {
        talkModulePage.yesButtonForDelete.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);
    }
    @Then("the user shouldn't see that {string} in the list")
    public void the_user_shouldn_t_see_that_in_the_list(String conversationName) {
        List<String> conversionList = new ArrayList<>();
        for(WebElement each : talkModulePage.conversationList){
            conversionList.add(each.getText());
        }
        Assert.assertTrue(!conversionList.contains(conversationName));

    }
}
