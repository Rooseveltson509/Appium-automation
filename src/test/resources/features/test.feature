@non-reg
Feature: As a user I want connect to the store

  @Register
  Scenario Outline: Test 1
    Given I am on the home page
    When I go to the register page and I create account with "<email>" and "<password>" and "<cPassword>"
    Then I am on the account page
    Examples:
      | email           | password   | cPassword  |
      | roose@gmail.com | roosetest1 | roosetest1 |

  @Login
  Scenario Outline: Test 2
    Given I am on the login page
    When I go to the login page and I signing with my "<email>" and my "<password>"
    Then I am on the store catalogue
    Examples:
      | email           | password   |
      | roose@gmail.com | roosetest1 |