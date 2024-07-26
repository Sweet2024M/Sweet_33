Feature: User Management

  Scenario: Admin creates a new user account
    Given the admin is logged in
    When the admin enters the command "create user"
    And the admin provides the user details
    Then the system creates a new user account
    And the admin sees a confirmation message

  Scenario: Admin updates an existing user account
    Given the admin is logged in
    When the admin enters the command "update user [user_id]"
    And the admin provides the new user details
    Then the system updates the user's information
    And the admin sees a confirmation message

  Scenario: Admin deletes a user account
    Given the admin is logged in
    When the admin enters the command "delete user [user_id]"
    Then the system deletes the user account
    And the admin sees a confirmation message
