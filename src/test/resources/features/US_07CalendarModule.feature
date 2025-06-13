@calendar
Feature: Calendar Module Functionality
  #As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Background:
    Given user is logged in
    And user clicks on Calendar module


  Scenario Outline: User can display daily calendar view
    When the user clicks on menu option
    And the user clicks on the <Option> view option
    Then the calendar should display events in daily view
    Examples:
      | Option |
      | "Day"  |


  Scenario Outline: User can display weekly calendar view
    When the user clicks on menu option
    And the user clicks on the <Option> view option
    Then the calendar should display events in weekly view
    Examples:
      | Option |
      | "Week" |


  Scenario Outline: User can display monthly calendar view
    When the user clicks on menu option
    And the user clicks on the <Option> view option
    Then the calendar should display events in monthly view
    Examples:
      | Option  |
      | "Month" |


  Scenario Outline: User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
    When the user clicks on the New event button
    And the user enters event title <titleName>
    And the user selects date from <year>-<month>-<day>
    And the user selects time <hour>:<minute> <AM/PM>
    And the user clicks Save
    Then the new event <string1> should appear on the <Option> calendar on the same date <year>-<month>-<day>
    Examples:
      | titleName         | year | day | hour | minute | AM/PM | string1           | month | Option  |
      | "Standup meeting" | 2025 | 12  | 12   | 30     | "AM"  | "Standup meeting" | 2     | "Month" |


  Scenario Outline: User can delete any event through the Monthly Calendar view by clicking on the event and then using “more” option
    When the user is viewing the calendar in <Option> view
    And the user sees an existing event on <year>-<month>-<day>
    When the user clicks on the <titleName> event
    And the user clicks on the More option
    And the user clicks on the Delete button after clicks on three dots
    Then the event titled <titleName> should no longer be visible on the calendar
    Examples:
      | Option  | titleName         | year | month | day |
      | "Month" | "Standup meeting" | 2025 | 2     | 12  |

