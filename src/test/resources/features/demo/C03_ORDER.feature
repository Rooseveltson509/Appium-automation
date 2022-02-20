Feature: Placing an Order

  @demo
  Scenario Outline: As a user i want to place an order
    Given I am on the product catalog page
    And I choose the product "<product1>"
    And I choose another product "<product2>"
    Then I am on the product detail page
    Examples:
      | product1   | product2 |
      | Nike Sport |Logitech  |