package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.CalendarModulePage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CalendarModule_StepDefs {
    BasePage basePage;
    CalendarModulePage calendarModulePage=new CalendarModulePage();

    @Given("user clicks on Calendar module")
    public void user_clicks_on_calendar_module() {
        basePage=new BasePage();
        basePage.calendarModuleButton.click();
        BrowserUtils.sleep(1);
    }
    @When("the user clicks on menu option")
    public void theUserClicksOnMenuOption() {
        calendarModulePage.menuOption.click();
        BrowserUtils.sleep(1);
    }
    @When("the user clicks on the {string} view option")
    public void the_user_clicks_on_the_view_option(String option) {
        Driver.getDriver().findElement(By.xpath("//span[.='"+option+"']")).click();
    }
    @Then("the calendar should display events in daily view")
    public void the_calendar_should_display_events_in_daily_view() {
        List<String> titleList = new ArrayList<>();
        for(WebElement each : calendarModulePage.titleList){
            titleList.add(each.getText());
        }
        Assert.assertTrue(titleList.size()==1);
    }
    @Then("the calendar should display events in weekly view")
    public void theCalendarShouldDisplayEventsInWeeklyView() {
        List<String> titleList = new ArrayList<>();
        for(WebElement each : calendarModulePage.titleList){
            titleList.add(each.getText());
        }
        Assert.assertTrue(titleList.size()==7);
    }
    @Then("the calendar should display events in monthly view")
    public void theCalendarShouldDisplayEventsInMonthlyView() {
        List<String> titleList = new ArrayList<>();
        for(WebElement each : calendarModulePage.monthTitleList){
            titleList.add(each.getText());
        }
        Assert.assertTrue(titleList.size()==42);
    }

    @When("the user clicks on the New event button")
    public void the_user_clicks_on_the_new_event_button() {
        calendarModulePage.newEventButton.click();
    }
    @When("the user enters event title {string}")
    public void the_user_enters_event_title(String titleName) {
        calendarModulePage.eventTitleBox.sendKeys(titleName);
    }
    @When("the user selects date from {int}-{int}-{int}")
    public void the_user_selects_date_from(Integer year, Integer month, Integer day) {
        calendarModulePage.fromDateBox.click();
        calendarModulePage.year.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-year='"+year+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-month ='"+(month-1)+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-day='"+day+"']")).click();
        BrowserUtils.sleep(1);

    }
    @When("the user selects time {int}:{int} {string}")
    public void the_user_selects_time(Integer hour, Integer minute, String amPm) {
        Driver.getDriver().findElement(By.xpath("//li[normalize-space(text())='"+hour+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//li[normalize-space(text())='"+minute+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//li[normalize-space(text())='"+amPm+"']")).click();
        BrowserUtils.sleep(1);
    }
    @When("the user clicks Save")
    public void the_user_clicks_save() {
        calendarModulePage.saveButton.click();
    }


    @Then("the new event {string} should appear on the {string} calendar on the same date {int}-{int}-{int}")
    public void theNewEventStringShouldAppearOnTheCalendarOnTheSameDateYearMonthDay(String expectedTitleName,String option, Integer year, Integer month, Integer day) {
        calendarModulePage.menuOption.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//span[.='"+option+"']")).click();
        calendarModulePage.date.click();
        BrowserUtils.sleep(1);
        calendarModulePage.year.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-year='"+year+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-month ='"+(month-1)+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-day='"+day+"']")).click();
        BrowserUtils.sleep(1);

        String actualTitleName = calendarModulePage.eventTitleOnDate.getText();
        Assert.assertEquals(actualTitleName,expectedTitleName);
    }

    @When("the user is viewing the calendar in {string} view")
    public void the_user_is_viewing_the_calendar_in_view(String option) {
        calendarModulePage.menuOption.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//span[.='"+option+"']")).click();
    }
    @When("the user sees an existing event on {int}-{int}-{int}")
    public void the_user_sees_an_existing_event_on(Integer year, Integer month, Integer day) {
        calendarModulePage.date.click();
        BrowserUtils.sleep(1);
        calendarModulePage.year.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-year='"+year+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-month ='"+(month-1)+"']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[@data-day='"+day+"']")).click();
        BrowserUtils.sleep(1);
    }
    @When("the user clicks on the {string} event")
    public void the_user_clicks_on_the_event(String event) {
        Driver.getDriver().findElement(By.xpath("//div[.='"+event+"']")).click();
    }
    @When("the user clicks on the More option")
    public void the_user_clicks_on_the_more_option() {
        calendarModulePage.moreButton.click();
    }
    @When("the user clicks on the Delete button after clicks on three dots")
    public void the_user_clicks_on_the_delete_button_after_clicks_on_three_dots() {
        calendarModulePage.treeDotButton.click();
        calendarModulePage.deleteButton.click();
    }
    @Then("the event titled {string} should no longer be visible on the calendar")
    public void the_event_titled_should_no_longer_be_visible_on_the_calendar(String expectedTitle) {

        Assert.assertTrue(calendarModulePage.eventTitleOnDate.isDisplayed());

    }
}
