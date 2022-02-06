Feature: As a user i want to signing

  @Login
  Scenario Outline: Login page
    Given I am on the login page
    When I go to the login page and I signing with my "<email>" and "<password>"
    Then I am on the store page
    Examples:
      | email           | password   |
      | roose@gmail.com | roos       |
      | roose@gmail.com | roosetest1 |