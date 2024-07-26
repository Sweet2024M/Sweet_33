Feature: User Authentication

  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I select "<role>" as the user type
    And I enter "<username>" and "<password>"
    And I click the login button
    Then I should see the "<role>" dashboard

    Examples:
      | role                 | username  | password  |
      | Admin                | Hamode    | 123       |
      | Beneficiary User     | jawad     | 123       |
      | Raw Material Supplier| supplier1 | 123       |
      | Store Owner          | Owner1    | 123       |
      

    Scenario: Login with invalid credentials
    Given I am on the login page
    When I select "user" as the user type
    And I enter "invalidUser" and "invalidPass"
    And I click the login button
   Then I should see an error message indicating invalid credentials

  Scenario: Logout
    Given I am logged in as "Admin"
    When I click the logout button
    Then I should be redirected to the login page
