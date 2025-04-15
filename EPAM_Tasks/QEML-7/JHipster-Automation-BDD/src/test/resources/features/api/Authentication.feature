Feature: User Authorization
  As an user of the authentication API
  I want to ensure that authorization scenarios are correctly validated
  So that only validated users can have access

  Scenario: User has valid credentials for authorization
    Given the user has valid credentials
    When the user hits the POST request to the authentication endpoint
    Then the status code should be 200
    And an id token should be generated

  Scenario Outline: User enters invalid credentials for authorization
    Given the user enters invalid "<username>" or "<password>"
    When the user hits the POST request to the authentication endpoint
    Then the status code should be 401
    And the user should see "Unauthorized" message

    Examples:
      | username   | password      |
      | admin      | wrongPassword |
      | wrongAdmin | admin         |
      | wrongUser  | wrongPassword |