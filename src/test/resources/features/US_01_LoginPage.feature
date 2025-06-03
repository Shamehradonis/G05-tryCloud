Feature:Login page Functionality

#As a user, I should be able to log in.
  @login
  Scenario Outline: Successful login with valid credentials by clicking on the "Login button"
    Given the user is on the login page
    When the user enters valid <username> and <password> with <submitType>
    Then the user should see the url contains <url>
    And the user should see the username as <expectedUser>
    Examples:
      | username     | password      | submitType      | url                                                 | expectedUser |
      | "Employee1"  | "Employee123" | "Login button>" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee1"  |
      | "Employee50" | "Employee123" | "Login button>" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee50" |
      | "Employee15" | "Employee123" | "Login button>" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee15" |

