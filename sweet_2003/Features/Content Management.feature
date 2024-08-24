Feature: Content Management
  As an admin
  I want to manage the content shared on the system
  So that I can maintain quality and relevance

 
  Scenario: View all recipes
    Given I am on the content management page
    When I select View Recipe then I should see the all recipes in the list
    Then return back to the content management page

  Scenario: Delete a recipe
    Given I am on the content management page
    When  I select Delete and enter recipe name "orrio"
    Then I should see the all recipes in the list after deleted
    And return back to the content management page
    
  
  Scenario: response to  users feedback
    Given I am on the content management page
    When I select Respond feedback and enter the feedback id "1" and write response message "thank you bro"
    Then return back to the content management page

  Scenario: view user feedback
    Given I am on the content management page
    When I select View feedback
    Then I should see all feedbacks 
    And return back to the content management page
    
    
     Scenario: delete user feedback
    Given I am on the content management page
    When I select Delete feedback and enter id feedback "1"
    Then I should see all feedbacks 
    And return back to the content management page
