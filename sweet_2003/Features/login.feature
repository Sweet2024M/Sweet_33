Feature: User Authentication

  Scenario: Successful Login
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard
    And a welcome message should be displayed

  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And clicks the login button
    Then an error message should be displayed

  Scenario: Logout
    Given the user is logged in
    When the user clicks the logout button
    Then the user should be redirected to the login page
    And a logout confirmation message should be displayed

  Scenario: Unsuccessful Login with Blank Credentials
    Given the user is on the login page
    When the user leaves the username and password fields blank
    And clicks the login button
    Then an error message should be displayed indicating required fields