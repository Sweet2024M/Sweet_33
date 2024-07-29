Feature: User Management
  As an admin
  I want to manage user accounts including users, store owners, and raw material suppliers
  So that I can control access to the system

  Scenario: View all user accounts
    Given I am logged in as an admin
    When I navigate to the user management page
    Then I should see a list of all user accounts including users, store owners, and raw material suppliers

  Scenario: Add a new user account
    Given I am logged in as an admin
    And I am on the user management page
    When I select Add User
    And I fill in the user username "ahmad" and password "123"
    Then submit details 
    And I should see the new user in the list

  Scenario: Add a new store owner account
    Given I am logged in as an admin
    And I am on the user management page
    When I select Add Store Owner
    And I fill in the store owner username "ahmad" and password "123"
    Then submit details
    And I should see the new store owner in the list

  Scenario: Add a new raw material supplier account
    Given I am logged in as an admin
    And I am on the user management page
    When I click on Add Supplier
    And I fill in the supplier username "ahmad" and password "123"
    Then submit details
    And I should see the new supplier in the list

 
  Scenario: Delete a user account
    Given I am logged in as an admin
    And I am on the user management page
    When I select a user account
    And I select Delete
    Then the user account should be deleted
    And delete success message 
