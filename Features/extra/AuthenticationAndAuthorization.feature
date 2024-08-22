Feature: Authentication and Authorization
  As a system
  I want to authenticate users based on their role
  So that only authorized users can access specific features

  Scenario: Authenticate a store owner with correct credentials
    Given I have a store owner with username "store_owner_1" and password "password456"
    When I log in with username "store_owner_1" and password "password456" as a "Store_owner"
    Then I should be logged in as a store owner
  Scenario: Fail to authenticate with incorrect credentials
    Given I have a store owner with username "store_owner_1" and password "password456"
    When I log in with username "store_owner_1" and password "wrong_password" as a "Store_owner"
    Then I should see an error message "Invalid username or password."
    