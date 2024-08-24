
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
    When the user enters username  "mahmoud" password "123" and role "Material_supplier"
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "mahmoud" and password "123" role "user" 
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "mahmoud" and password "123" role "Store_owner"
    Then user enters to the dash
    
    Scenario: User signs in with valid details 
    Given the user is not logged in 
    When the user enters username "mahmoud" and password "123" role "Admin"
    Then user enters to the dash
    
  Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "ahmad" and I enter the new username "ahmad" and I enter the new password "123" 
    Then update successful 
    And user returns to dash
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "ahmadU" and I enter the new username "ahmadU" and I enter the new password "123" 
    Then update successful 
    And user returns to dash
    
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "ahmadM" and I enter the new username "ahmadM" and I enter the new password "123" 
    Then update successful 
    And user returns to dash
    
    
    Scenario: User updates his password 
    Given the user is logged in 
    When I choose to update my information with oldusername "ahmadA" and I enter the new username "ahmadA" and I enter the new password "123" 
    Then update successful 
    And user returns to dash
    
    


   Scenario: Post and share personal dessert creations
    Given the user is logged in
    When I choose to post a new dessert creation with name "Chocolate Cake", ingredients "flour, sugar, cocoa"
    Then the dessert creation should be shared successfully
    And user returns to dash
  
  
  
  
  
