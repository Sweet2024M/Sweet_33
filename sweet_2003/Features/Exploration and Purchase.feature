Feature: Exploration and Purchase
  As a Beneficiary User
  I want to browse, search, and purchase desserts
  So that I can find and enjoy delicious treats

  Scenario: Browse dessert recipes
    Given I am logged in as a Beneficiary User
    When I navigate to the Recipes page
    Then I should see a list of dessert recipes

  Scenario: Filter recipes based on dietary needs
    Given I am logged in as a Beneficiary User
    When I navigate to the Recipes page
    And I apply a dietary filter
    Then I should see a list of recipes matching the filter

  Scenario: Purchase desserts
    Given I am logged in as a Beneficiary User
    When I navigate to a product page
    And I add the product to my cart
    And I proceed to checkout
    And I complete the purchase
    Then the dessert should be purchased
