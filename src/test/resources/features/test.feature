@non-reg
Feature: As a user I want connect to the store
  @Register
  Scenario Outline: Test 1
    Given I am on the home page
    When I go to the register page and I create account with "<email>" and "<password>" and "<cPassword>"
    Then I am on the account page
    Examples:
      | email           | password   | cPassword  |
      | roosegmail.com  | roosetest1 | roosetest1 |
      | roose3gmail.com | roosetest1 | roosetest1 |

  @Login
  Scenario Outline: Test 2
    Given I am on the login page
    When I go to the login page and I signing with my "<email>" and "<password>"
    And I am on the store catalogue
    And I choose one product and i add i increase and add it to the cart
    And I return to the catalogue of product i choose another product and i increase and add it to the cart
    And I go to my cart
    And I validate my cart with card number "<cardNumber>" and expiration date "<expirationDate>" and "<CVC>"
    Then I payed my order
    Examples:
      | email           | password   | cardNumber       | expirationDate | CVC |
      | roose@gmail.com | roosetest1 | 4242424242424242 | 1122           | 123 |
      | roose@gmail.com | roosetest1 | 4242424242424248 | 1122           | 123 |