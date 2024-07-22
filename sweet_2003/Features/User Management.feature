Feature: User Management
  As an Admin
  I want to manage user accounts including store owners and raw material suppliers
  So that I can control system access and permissions

  Scenario: Add a new user
    Given I am logged in as an Admin
    When I navigate to the User Management page
    And I fill in the new user details
    And I submit the form
    Then the new user should be created

  Scenario: Update a user
    Given I am logged in as an Admin
    And a user exists
    When I navigate to the User Management page
    And I select a user to update
    And I modify the user details
    And I submit the changes
    Then the user details should be updated

  Scenario: Delete a user
    Given I am logged in as an Admin
    And a user exists
    When I navigate to the User Management page
    And I select a user to delete
    And I confirm the deletion
    Then the user should be removed from the system
