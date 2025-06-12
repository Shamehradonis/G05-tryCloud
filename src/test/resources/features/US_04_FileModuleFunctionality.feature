@wip_Emmanuel
Feature: File Module Functionality

  Agile: As a user, I should be able to upload a file, move or delete any selected file under the Files module __

  Background:
    Given the user is on the login page
    And the user enters valid username and password and click loginButton
    And the user should click on the Files Module
    #And the user should see "Files - Trycloud QA" in the title

  Scenario: Upload a file
    When the user should click the + sign button
    And the user should click on upload a file option
    And the user should click on the file name "EmmanuelFile.txt" and press enter
    Then the file name "EmmanuelFile" should be visible in the list


  Scenario: create a new folder
    When the user should click the + sign button
    And the user should click on the new folder option
    And the user should name the folder "AutomationTestingED"
    Then the folder name "AutomationTestingED" should be visible in the list


  Scenario: move a selected file to a folder and verify it is inside the folder
    Given the user select the file name EmmanuelFile by clicking on the checkbox
    When the user click on the three dots button
    And the user click on Move or Copy option
    And the user choose the AutomationTestingED folder from the list
    And  the user clicks the Move button
    Then the file named "EmmanuelFile.txt" should be visible inside the folder "AutomationTestingED"


  Scenario: delete any selected item
    When the user should click the + sign button
    And the user should click on the new folder option
    And the user should name the folder "Manual testing"
    And the user select the "Manual testing" folder checkbox
    And the user click on the three dots button by the selected folder
    And the user click on Deleted folder option
    And the user clicks on the Deleted files menu
    Then the "Manual testing" folder should be visible on the Deleted files list


  Scenario: total number of files and folders under the files list table
    Then the user should see the total number of files and folders







