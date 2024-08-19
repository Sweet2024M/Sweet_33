Feature: Login and Logout

  Scenario: Successfully login
    Given the user is not logged in
    When the user enters the username "mohammad" and the password "123"
    Then the user is logged in
    And a success message pops up

  Scenario: Unsuccessful login
    Given the user is not logged in
    When the user enters a wrong username and a wrong password
    Then the user can't log in
    And an unsuccessful message pops up

  Scenario: Logout
    Given the user is already logged in
    When the user chooses the logout option
    Then the user is logged out
