#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature:  Product Management  

  Scenario: Store owner adds a new product
    Given the store owner is logged in
    When the store owner navigates to the Manage Products section to show products 
    And the store owner choose Add New Product
    And the store owner enters the product details
    And the store owner chooses save
    Then the new product should be added successfully

  Scenario: Store owner removes a product
    Given the store owner is logged in
    When the store owner navigates to the Manage Products section to show products
    And the store owner choose remove a Product
    And the store owner enters the product name
    And the store owner chooses save
    Then the product should be removed successfully
    
  Scenario: Store owner updates a product
    Given the store owner is logged in
    When the store owner navigates to the Manage Products section to show products
    And the store owner choose update a Product
    And the store owner enters the product name
    And the store owner chooses save
    Then the product should be updated successfully
    

  Scenario: Store owner monitors sales and profits
    Given the store owner is logged in
    When the store owner navigates to the Sales Reports section
    Then the store owner should see the sales and profits report
    
    
   Scenario: Store owner identifies best-selling products
    Given the store owner is logged in
    When the store owner navigates to the Sales Reports section
    And the store owner selects Best-Selling Products
    Then the best-selling products should be displayed
    
   Scenario: Store owner adds a discount
    Given the store owner is logged in
    When the store owner navigates to the Discount Management section
    And the store owner chooses Add New Discount
    And the store owner enters the discount details
    And the store owner Saves
    Then the discount should be added successfully


  Scenario: dynamic volume-based discount
    Given there is products  
    When the best seeling product is known 
    Then the volume-based 40% discount should be implemented successfully on that product

    
    
    
    
    
    
    
    
    
    
    