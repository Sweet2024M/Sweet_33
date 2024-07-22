Feature: Communication and Feedback
  As a Beneficiary User
  I want to communicate with store owners and provide feedback
  So that I can get assistance and share my experience

  Scenario: Communicate with store owners
    Given I am logged in as a Beneficiary User
    When I navigate to a store owner's page
    And I send a message
    Then the store owner should receive the message

  Scenario: Provide feedback on purchased products
    Given I am logged in as a Beneficiary User
    When I navigate to my order history
    And I select a purchased product
    And I write and submit feedback
    Then my feedback should be recorded
