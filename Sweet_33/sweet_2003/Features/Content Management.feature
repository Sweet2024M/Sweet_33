Feature: Content Management
  As an Admin
  I want to manage the content shared on the system including recipes and posts
  So that I can ensure the quality of content

  Scenario: Manage recipes
    Given I am logged in as an Admin
    When I navigate to the Recipes Management page
    Then I should see a list of all recipes
    And I should be able to add, update, or delete recipes

  Scenario: Manage posts
    Given I am logged in as an Admin
    When I navigate to the Posts Management page
    Then I should see a list of all posts
    And I should be able to add, update, or delete posts

  Scenario: Review user feedback
    Given I am logged in as an Admin
    When I navigate to the Feedback Management page
    Then I should see a list of user feedback
    And I should be able to respond to or delete feedback
