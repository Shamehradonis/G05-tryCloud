@deck
Feature:Deck Module Functionality

  Background:
    Given user is logged in
    And user clicks on Deck module
    And user clicks on Upcoming cards button


  Scenario Outline: User can create a new board
    When user clicks on Add boards button
    And user can put <Board name> inside the box
    And user clicks on arrow or hitting the enter as <submitType>
    Then user should see <New Board> under the All boards list
    And user should delete the <New Board> after test
    Examples:
      | Board name | submitType | New Board  |
      | "Quality"  | "arrow"    | "Quality"  |
      | "Security" | "enter"    | "Security" |


  Scenario Outline: User can create a new list of card/task under any board
    Given user open the board named <Board name>
    When user click on Add List
    And user enter <List name> as list name
    And user save the list by clicking on arrow
    Then user should see a list named <List name> in the board
    Examples:
      | Board name | List name |
      | "Personal" | "To Do"   |


  Scenario Outline: User can add a new card/task on any list on the current board
    Given user open the board named <Board name>
    When user click on Add Card in one of the <List name>
    And user enter <Task name> as card title
    And user save the card by clicking on arrow
    Then user should see a card titled <Task name> under the <List name> list
    Examples:
      | Board name | List name | Task name |
      | "Personal" | "To Do"   | "Task-1"  |


  Scenario Outline: User can assign any card/task to himself/herself by using the three dots on the related card
    Given user open the board named <Board name>
    When user click on three dots on the <Card name>
    And user click on <Option> button
    Then User profile icon should be displayed near the dots icon
    Examples:
      | Board name | Card name | Option         |
      | "Personal" | "Task-1"  | "Assign to me" |


  Scenario Outline: User can move any card on the current board to any other list of other board
    Given user open the board named <Board name>
    When user click on three dots on the <Card name>
    And user click on <Option> button
    And user select <New Board name> by clicking select a board
    And user select <List name> by clicking select a list
    And user click on Move card button
    And user should delete the <List name> after moving the card
    Then user should see that card <Card name> in board <New Board name> under list <List name>
    And user should delete the cart <Card name> after test
    Examples:
      | Board name | Card name | Option      | New Board name | List name |
      | "Personal" | "Task-1"  | "Move card" | "Operator"     | "To Do"   |



