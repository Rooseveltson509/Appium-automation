Feature: As a user I want connect to the store

  @SC02
  Scenario Outline: Register page
    Given I am on the home page
    When I go to the register page and I create account with "<email>" and "<password>" and "<cPassword>"
    Then I am registered
    Examples:
      | email           | password   | cPassword  |
      | roose@gmail.com | roosetest1 | roosetest1 |