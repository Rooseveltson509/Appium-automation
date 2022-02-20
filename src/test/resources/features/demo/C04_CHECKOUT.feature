Feature: Check out

  @demo
  Scenario Outline: as a user i want to paye my order
    Given I am on the order page
    When I enter my banking information my "<cardNumber>" and "<Exp>" and "<CVC>"
    Then I validate my order
    Examples:
      | cardNumber       | Exp  | CVC |
      | 4242424242424242 | 1122 | 12  |
      | 4242424242424242 | 1101 | 122 |
      | 4242424242424141 | 1222 | 123 |
      | 4242424242424242 | 1222 | 123 |