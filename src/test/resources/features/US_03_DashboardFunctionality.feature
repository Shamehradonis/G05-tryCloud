@DashboardFunctions
Feature: Dashboard Functions


  Background:
    Given user logged in


  @dashboardModules
  Scenario: After Login user can see all modules and Username.
    Then User should be able to see all modules below
      | Dashboard |
      | Files      |
      | Photos     |
      | Activity   |
      | Talk       |
      | Mail       |
      | Contacts   |
      | Circles    |
      | Calendar   |
      | Deck       |
    And User should be able to see the username "Employee15"






  Scenario: User can click on Customize button and see the widgets and backgrounds then select any of them
    When User clicks on customize button
    Then User should see the following widgets
      | Status |
      | Weather |
      | Upcoming events |
      | Upcoming cards |
      | Important mail |
      | Unread mail |
      | Recommended files |
      | Talk mentions |
      | Recent status |
    When User selects the "Status" widget checkbox
    Then The "Status" widget should be checked






    And User can see background images
    Then User select any of background images










  Scenario: Set Status Verification
    When User clicks on Set Status button
  Then User sees "Online status" options and select any of them
    |Online|
    |Away|
    |Do not disturb|
    |Invisible|
  Then User sees "Status messages" and select any of the them
    |In a meeting|
    |Commuting|
    |Working remotly|
    |Out sick|
    |Vacationing|

  Then User can Set or Clear "status messages"
  Then After these steps user see his/her selections on dashboard













 # 1 - After Login user can see all modules and Username.
 # 2 - User can click on Customize button and
  #a- User can see status widgets and select any of them
  #b- User can see background images and select any of them
  #3 - User can click on Set Status button and
  #a- User sees Online status options and select any of them
  #b- User sees Status messages and select any of them
  #c- User can Set or Clear status messages
  #d- After these steps user can see his/her selections on dashboard