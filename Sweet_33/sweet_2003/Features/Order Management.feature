Feature: Order Management
  As a Store Owner or Raw Material Supplier
  I want to process and track orders
  So that I can manage my sales

  Scenario: Process an order
    Given I am logged in as a Store Owner or Raw Material Supplier
    When I navigate to the Orders page
    And I select an order to process
    And I update the order status
    Then the order status should be updated

  Scenario: Track an order
    Given I am logged in as a Store Owner or Raw Material Supplier
    When I navigate to the Orders page
    Then I should see a list of all orders with their current statuses
