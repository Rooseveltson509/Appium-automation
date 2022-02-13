Feature: Check out

  @SC022
  Scenario Outline: as a user i want to paye my order
    Given I am on the order page
    And I enter my banking information my "<cardNumber>" and "<Exp>" and "<CVC>"
    Then I validate my order
    Examples:
      | cardNumber       | Exp  | CVC |
      | 4242424242424242 | 1222 | 123 |