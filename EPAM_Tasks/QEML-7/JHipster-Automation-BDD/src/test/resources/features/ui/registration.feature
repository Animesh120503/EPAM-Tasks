Feature: Register new user
  As an user
  I want to register myself
  So that I can create a new account

  Scenario Outline: Register with valid data
    Given I am on registration page
    When I enter valid "<username>" and "<email>" and "<password>" and "<confirmPassword>"
    And click register button
    Then I should be see a success message

    Examples:
      | username | email                  | password | confirmPassword |
      | Animesh  | someUser@localHost.com | 123456   | 123456          |
      | H        | someUser@localHost     | pass     | pass            |

#  Scenario Outline: Register with invalid data
#    Given I am on registration page
#    When I enter invalid "<username>" and "<email>" and "<password>" and "<confirmPassword>"
#    And click register button
#    Then I should be see a error message
#
#    Examples:
#      | username | email | password | confirmPassword |