Feature: User Login
  As a user
  I want to log in to the application with valid credentials
  So that I can access my account

  Background:
    Given I am on the login page

  Scenario: Successful login as a regular user
    When I log in with valid credentials
    Then I should see a user success message in main page

  Scenario: Successful login as an admin
    When I log in with valid admin credentials
    Then I should see a admin success message in main page

  Scenario Outline: Login failure with invalid credentials
    When I log in with invalid "<username>" and "<password>"
    Then I should see an error message in the login page

    Examples:
      | username   | password      |
      | wrongAdmin | admin         |
      | admin      | wrongPassword |
      | wrongUser  | wrongPassword |