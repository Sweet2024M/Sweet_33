
Feature: User Account
  Scenario: User signs up for a new account
    Given the user is not logged in 
    When the user enters username  "mahmoud" password "123" and role "Material_supplier"
    Then the user account should be created successfully
    
     Scenario: User signs up for a new account
    Given the user is not logged in 
    When the user enters username  "mahmoud" password "123" and role "user"
    Then the user account should be created successfully
    
     Scenario: User signs up for a new account
    Given the user is not logged in 
    When the user enters username  "mahmoud" password "123" and role "Store_owner"
    Then the user account should be created successfully
    
     Scenario: User signs up for a new account
    Given the user is not logged in 
    When the user enters username  "mahmoud" password "123" and role "Admin"
    Then the user account should be created successfully
    
    
    
  Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username  "soj" password "15" and role "Material_supplier"
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "esa" and password "1234" role "user" 
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "shafiq" and password "16" role "Store_owner"
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "abd" and password "123" role "Admin"
    Then user enters to the dash
    
  Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "mahmoud" and I enter the new username "mahmoud" and I enter the new password "1234" 
    Then update successful 
    And user returns to dash
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "mahmoud" and I enter the new username "mahmoud" and I enter the new password "1234" 
    Then update successful 
    And user returns to dash
    
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "mahmoud" and I enter the new username "mahmoud" and I enter the new password "1234" 
    Then update successful 
    And user returns to dash
    
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "mahmoud" and I enter the new username "mahmoud" and I enter the new password "1234" 
    Then update successful 
    And user returns to dash
    
    


   Scenario: Post and share personal dessert creations
    Given the user is logged in
    When I choose to post a new dessert creation with name "Chocolate Cake", ingredients "flour, sugar, cocoa"
    Then the dessert creation should be shared successfully
    And user returns to dash
  
  
  
  
  