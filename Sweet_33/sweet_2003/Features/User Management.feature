Feature: User Management
 # As an Admin
 # I want to manage user accounts including store owners and raw material suppliers
 # So that I can control system access and permissions

  Scenario: Add a new user
    Given I am logged in as an Admin
    When I select to add a user
    And I fill in the new user details
    Then the new user should be created

  Scenario: Update a user
    Given I am logged in as an Admin
    And a user exists
    When I select a user to update
    Then the user details should be updated

  Scenario: Delete a user
    Given I am logged in as an Admin
    And a user exists
    When I select a user to delete
    Then the user should be removed from the system
