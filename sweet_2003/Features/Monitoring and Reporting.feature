Feature: Monitoring and Reporting
  As an Admin
  I want to monitor profits and generate financial reports
  So that I can understand the performance of the business

  Scenario: View financial reports
    Given I am logged in as an Admin
    When I navigate to the Reports page
    Then I should see the financial reports

  Scenario: Identify best-selling products
    Given I am logged in as an Admin
    When I navigate to the Best-Selling Products page
    Then I should see a list of the best-selling products in each store

  Scenario: View user statistics by city
    Given I am logged in as an Admin
    When I navigate to the User Statistics page
    Then I should see statistics on registered users by city
