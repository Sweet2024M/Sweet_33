Feature: File Management Operations
  As a system
  I want to update user details in a file
  So that I can maintain accurate records

  Scenario: Update a file 
    Given I am logged in as an admin
    When I give an old username "ahmad" username "ahmad1" and password "123" 
    Then the file should be updated and rewrite file
    