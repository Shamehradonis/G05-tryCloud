@logout
Feature: US-02 Log out Functionality
  #As a user, I should be able to log out.

Background:
  Given user logged in

  Scenario: User can log out and ends up in login page
    When user click on account button
    And user click the logout button
    Then user should be redirected to the login page

    Scenario: User can not go to home page again by clicking step back button after successfully logged out.
      When user click on account button
      And user click the logout button
      And user should be redirected to the login page
      And user click on step back button
      Then user still in logging page

    Scenario: Users must be logged out if the user is away from keyboard for 3 minutes
      When user does not do any mouse or keyboard action for 3 minutes
      Then user must be logged out

