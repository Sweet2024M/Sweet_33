Feature: Product Management
  As a Store Owner or Raw Material Supplier
  I want to manage my products
  So that I can control the items available for sale

  Scenario: Add a product
    Given I am logged in as a Store Owner or Raw Material Supplier
    When I navigate to the Product Management page
    And I fill in the new product details
    And I submit the form
    Then the new product should be added

  Scenario: Update a product
    Given I am logged in as a Store Owner or Raw Material Supplier
    And a product exists
    When I navigate to the Product Management page
    And I select a product to update
    And I modify the product details
    And I submit the changes
    Then the product details should be updated

  Scenario: Delete a product
    Given I am logged in as a Store Owner or Raw Material Supplier
    And a product exists
    When I navigate to the Product Management page
    And I select a product to delete
    And I confirm the deletion
    Then the product should be removed from the system
