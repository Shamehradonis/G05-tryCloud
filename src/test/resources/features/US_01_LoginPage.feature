@login
Feature:Login page Functionality

#As a user, I should be able to log in.

  Scenario Outline: Successful login with valid credentials by clicking on the "Login button"
    Given the user is on the login page
    When the user enters valid <username> and <password> with <submitType>
    Then the user should see the url contains <url>
    And the user should see the username as <expectedUser>
    Examples:
      | username     | password      | submitType     | url                                                 | expectedUser |
      | "Employee1"  | "Employee123" | "Login button" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee1"  |
      | "Employee50" | "Employee123" | "Login button" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee50" |
      | "Employee15" | "Employee123" | "Login button" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee15" |

  Scenario Outline: Successful login with valid credentials by hitting the "Enter"
    Given the user is on the login page
    When the user enters valid <username> and <password> with <submitType>
    Then the user should see the url contains <url>
    And the user should see the username as <expectedUser>
    Examples:
      | username     | password      | submitType | url                                                 | expectedUser |
      | "Employee1"  | "Employee123" | "enterKey" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee1"  |
      | "Employee50" | "Employee123" | "enterKey" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee50" |
      | "Employee15" | "Employee123" | "enterKey" | "https://qa.trycloud.net/index.php/apps/dashboard/" | "Employee15" |


  Scenario Outline: User cannot login with any invalid credentials "Wrong username or password." should be displayed
  Fon invalid credentials
    Given the user is on the login page
    When the user is logged in <username> and <password> with <submitType>
    Then the user should see the message <expectedError>
    Then the user should see the url contains <url>
    Examples:
      | username    | password      | submitType     | expectedError                 | url                                             |
      | "Employe1"  | "Employee123" | "Login button" | "Wrong username or password." | "https://qa.trycloud.net/index.php/login?user=" |
      | "Employee1" | "Employee"    | "Login button" | "Wrong username or password." | "https://qa.trycloud.net/index.php/login?user=" |
      | "Employe1"  | "Employee123" | "enterKey"     | "Wrong username or password." | "https://qa.trycloud.net/index.php/login?user=" |
      | "Employee1" | "Employee"    | "enterKey"     | "Wrong username or password." | "https://qa.trycloud.net/index.php/login?user=" |


  Scenario Outline: User cannot login with any invalid credentials "Please fill out this field" message should be displayed if the password or username is empty
    Given the user is on the login page
    When the user is logged in <username> and <password>
    Then the user should see the <massage> if <anyField> is empty
    Examples:
      | username    | password      | massage                       | anyField   |
      | ""          | "Employee123" | "Please fill out this field." | "username" |
      | "Employee1" | ""            | "Please fill out this field." | "password" |


  Scenario: User can see the password in a form of dots by default
    Given the user is on the login page
    Then the password should be masked by default

  Scenario: User can see the password explicitly if needed
    Given the user is on the login page
    Then  Password visibility toggle allows user to see password explicitly

  Scenario: User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
    Given the user is on the login page
    Then the user should see the Forgot password? link.
    When the user click on the Forgot password? link.
    And Wait for the password reset page to load.
    Then The user should see the Reset Password button


  Scenario Outline: User can see valid placeholders on Username and Password fields
    Given the user is on the login page
    Then the username field should have placeholder <expectedPlaceholder1>
    And the password field should have placeholder <expectedPlaceholder2>
    Examples:
      | expectedPlaceholder1 | expectedPlaceholder2 |
      | "Username or email" | "Password"          |


