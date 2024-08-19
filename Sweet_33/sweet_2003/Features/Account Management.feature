Feature: Account Management
  As a Store Owner or Raw Material Supplier
  I want to manage my account details
  So that I can keep my business information up to date

  Scenario: Update account details
    Given I am logged in as a Store Owner or Raw Material Supplier
    When I navigate to the Account Management page
    And I update my business information
    And I submit the changes
    Then my account details should be updated
