Feature: User Account
  As a Beneficiary User
  I want to manage my personal account
  So that I can use the system effectively

  Scenario: Sign up for a new account
    Given I am on the Sign-Up page
    When I fill in the required details
    And I submit the form
    Then my account should be created

  Scenario: Sign in to the platform
    Given I am on the Sign-In page
    When I enter my username and password
    And I submit the form
    Then I should be logged in

  Scenario: Manage personal account details
    Given I am logged in as a Beneficiary User
    When I navigate to the Account Management page
    And I update my personal details
    And I submit the changes
    Then my account details should be updated
