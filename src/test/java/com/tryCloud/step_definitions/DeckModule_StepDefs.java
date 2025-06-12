package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.DeckModulePage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeckModule_StepDefs {

LoginPage loginPage;
BasePage basePage;
DeckModulePage deckModulePage = new DeckModulePage();
    @Given("user is logged in")
    public void user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage=new LoginPage();
        loginPage.login();
    }
    @Given("user clicks on Deck module")
    public void user_clicks_on_deck_module() {
        basePage=new BasePage();
        basePage.deckModule.click();
    }
    @And("user clicks on Upcoming cards button")
    public void userClicksOnUpcomingCardsButton() {
        deckModulePage.upcomingCards.click();
    }
    @When("user clicks on Add boards button")
    public void user_clicks_on_add_boards_button() {
        deckModulePage.addBoardButton.click();
    }
    @When("user can put {string} inside the box")
    public void user_can_put_inside_the_box(String boardName) {
        deckModulePage.boardNameBox.sendKeys(boardName);
    }
    @When("user clicks on arrow or hitting the enter as {string}")
    public void user_clicks_on_arrow_or_hitting_the_enter_as(String submitType) {
        if (submitType.contains("arrow")) {
            deckModulePage.arrow.click();
        } else if (submitType.contains("enter")) {
            deckModulePage.boardNameBox.sendKeys(Keys.ENTER);
        } else {
            System.err.println("Not valid SubmitType");
        }

        deckModulePage.upcomingCards.click();
        BrowserUtils.sleep(1);
        deckModulePage.upcomingCards.click();
        BrowserUtils.sleep(1);
    }
    @Then("user should see {string} under the All boards list")
    public void user_should_see_under_the_all_boards_list(String newBoard) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : deckModulePage.allBoards) {
            texts.add(element.getText());
        }
        Assert.assertTrue(texts.contains(newBoard));
    }
    @Then("user should delete the {string} after test")
    public void user_should_delete_the_after_test(String newBoard) {
Driver.getDriver().findElement(By.xpath("//span[@title='"+newBoard+"']/ancestor::li[1]//button")).click();
deckModulePage.deleteBoardButton.click();
        deckModulePage.deleteButton.click();
    }

    @Given("user open the board named {string}")
    public void user_open_the_board_named(String boardName) {
        Driver.getDriver().findElement(By.xpath("//span[@title='"+boardName+"']")).click();
    }
    @When("user click on Add List")
    public void userClickOnAddList() {
        deckModulePage.addListButton.click();
    }
    @When("user enter {string} as list name")
    public void user_enter_as_list_name(String listName) {
        deckModulePage.listNameBox.sendKeys(listName);
    }
    @And("user save the list by clicking on arrow")
    public void userSaveTheListByClickingOnArrow() {
        deckModulePage.listNameArrow.click();
        Driver.getDriver().navigate().refresh();
    }
    @Then("user should see a list named {string} in the board")
    public void user_should_see_a_list_named_in_the_board(String listName) {
        List<String> listNames = new ArrayList<>();
        for (WebElement element : deckModulePage.listNames) {
            listNames.add(element.getText());
        }
        Assert.assertTrue(listNames.contains(listName));
    }

    @When("user click on Add Card in one of the {string}")
    public void user_click_on_add_card_in_one_of_the(String listName) {
        Driver.getDriver().findElement(By.xpath("//h3[normalize-space(text())='"+listName+"']/following::button[2]")).click();
    }
    @When("user enter {string} as card title")
    public void user_enter_as_card_title(String cardName) {
        deckModulePage.cardNameBox.sendKeys(cardName);
    }
    @When("user save the card by clicking on arrow")
    public void user_save_the_card_by_clicking_on_arrow() {
        deckModulePage.cardNameArrow.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(3);
    }
    @Then("user should see a card titled {string} under the {string} list")
    public void user_should_see_a_card_titled_under_the_list(String expectedCardName, String listName) {

       String actualCardName = Driver.getDriver().findElement(By.xpath("//h3[normalize-space(text())='"+listName+"']/following::span[4]")).getText();
       Assert.assertEquals(actualCardName,expectedCardName);
    }

    @When("user click on three dots on the {string}")
    public void user_click_on_three_dots_on_the(String cardName) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+cardName+"']/following::button[1]")).click();
    }
    @When("user click on {string} button")
    public void user_click_on_button(String option) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+option+"']")).click();
        BrowserUtils.sleep(2);
    }
    @Then("User profile icon should be displayed near the dots icon")
    public void user_profile_icon_should_be_displayed_near_the_dots_icon() {
        Assert.assertTrue(deckModulePage.accountIcon.isDisplayed());
    }
    @When("user select {string} by clicking select a board")
    public void user_select_by_clicking_select_a_board(String boardName) {
        deckModulePage.selectBoardButton.click();
        Driver.getDriver().findElement(By.xpath("//span[.='"+boardName+"']")).click();
    }
    @When("user select {string} by clicking select a list")
    public void user_select_by_clicking_select_a_list(String listName) {
        deckModulePage.selectListButton.click();
        Driver.getDriver().findElement(By.xpath("//span[.='"+listName+"']")).click();
    }
    @When("user click on Move card button")
    public void user_click_on_move_card_button() {
        deckModulePage.moveCardButton.click();
    }
    @And("user should delete the {string} after moving the card")
    public void userShouldDeleteTheListNameAfterMovingTheCard(String listName) {
        Driver.getDriver().findElement(By.xpath("//h3[normalize-space(text())='"+listName+"']/following::button[1]")).click();
        deckModulePage.deleteListButton.click();

    }
    @Then("user should see that card {string} in board {string} under list {string}")
    public void user_should_see_that_card_in_board_under_list(String expectedCardName,String boardName, String listName) {
        Driver.getDriver().findElement(By.xpath("//span[@title='"+boardName+"']")).click();
        BrowserUtils.sleep(1);
        String actualCardName = Driver.getDriver().findElement(By.xpath("//h3[normalize-space(text())='"+listName+"']/following::span[4]")).getText();
        System.out.println("actualCardName = " + actualCardName);
        Assert.assertEquals(actualCardName,expectedCardName);
        BrowserUtils.sleep(3);

    }

    @And("user should delete the cart {string} after test")
    public void userShouldDeleteTheCartAfterTest(String cardName) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+cardName+"']/following::button")).click();
        deckModulePage.deleteCardButton.click();
    }
}
