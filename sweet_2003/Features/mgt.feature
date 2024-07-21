Feature: User Management

  Scenario: Admin adds a new store owner account
    Given the admin is logged in
    When the admin navigates to the "Manage Users" section
    And the admin clicks on "Add New User"
    And the admin enters the required details for the store owner
    And the admin clicks on "Save"
    Then the new store owner account should be created successfully

  Scenario: Admin removes a raw material supplier account
    Given the admin is logged in
    When the admin navigates to the "Manage Users" section
    And the admin selects a raw material supplier account
    And the admin clicks on "Delete"
    Then the raw material supplier account should be removed successfully
