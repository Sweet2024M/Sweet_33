Feature: Communication and Notification
  As a Store Owner or Raw Material Supplier
  I want to communicate with users and other suppliers
  So that I can manage my business effectively

  Scenario: Send a message
    Given I am logged in as a Store Owner or Raw Material Supplier
    When I navigate to the Messaging page
    And I select a recipient
    And I write a message
    And I send the message
    Then the recipient should receive the message

  Scenario: Receive notifications for special requests
    Given I am logged in as a Store Owner or Raw Material Supplier
    And there is a special request
    When the request is made
    Then I should receive an email notification (optional/bonus)
