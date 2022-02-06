Feature: As a user i want to signing

  @SC01
  Scenario Outline: Login page
    Given I am on the login page
    When I go to the login page and I signing with my "<email>" and "<password>"
    Then I am on the store page
    Examples:
      | email           | password   |
      | roosegmail.com  | roosetest1 |
      | roose@gmail.com | roosetest1 |