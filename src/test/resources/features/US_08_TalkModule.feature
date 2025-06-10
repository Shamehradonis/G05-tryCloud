@talk
Feature: Talk Module Functionality
  #As a user, I should be able to create a new conversation, add participant, start and leave call under the Talk module

  Background:
    Given user is logged in
    And user clicks on Talk module


  Scenario Outline: User can create a new conversation
    When the user clicks on Create a new group conversation
    And enters a <Conversation name>
    And put the check on Allow quest to join via link
    And clicks on Add participants
    And add at least one user like <User name>
    And click on Create conversation
    Then a new conversation <Conversation name> should appear in the conversation list
    Examples:
      | Conversation name | User name   |
      | "Group05"         | "Employee1" |


  Scenario Outline: User can add any selected participant to any conversation
    Given the user selects any <conversation> from list
    When the user clicks on Add Participant to the conversation
    And selects a <user> from the contacts
    Then the selected <user> should appear in the participant list
    Examples:
      | conversation | user         |
      | "Group05"    | "Employee10" |

  Scenario: Display all conversation list under the Talk module
    Then the user should see a list of all their existing conversations

  Scenario Outline: User can start a call with any participant and leave the call
    Given the user selects any <conversation> from list
    When the user clicks on the Start Call button
    Then a call window should open
    When the user clicks the Leave Call button
    Then the call window should close
    Examples:
      | conversation |
      | "Group05"    |


  Scenario Outline: User can delete a conversation
    Given the user clicks on three dots of any <conversation> from list
    When clicks on Delete conversation from the option list
    And clicks on yes in confirmation massage for delete after that
    Then the user shouldn't see that <conversation> in the list
    Examples:
      | conversation |
      | "Group05"    |



