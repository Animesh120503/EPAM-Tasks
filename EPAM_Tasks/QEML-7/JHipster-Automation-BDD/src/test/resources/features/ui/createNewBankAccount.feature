Feature: Create New Bank Account
  As an user
  I want to create a new bank account
  So that I can use it for banking purpose

  Scenario Outline: Open a new bank account with valid data
    Given User is logged in
    And User is on the bank accounts page
    When User clicks on create new bank account button
    And User enters valid "<name>" and "<balance>" and "<user>"
    Then a new bank account with "<name>" and "<balance>" and "<user>" is created
    Examples:
      | name      | balance | user  |
      | New User  | 20000   | user  |
      | 123       | -9000   | user  |
      | new Admin | 0       | admin |