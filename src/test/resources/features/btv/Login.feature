Feature: As a user I want to connect to my customer area

  @btv
  Scenario Outline: As a user I log in to my customer area
    Given I am on the login page btv
    When  connect with my "<login>" and "<number>" and "<password>"
    Then I am connected
    Examples:
      | login  | number     | password       |
      | zenity | 0100000000 | ZenityTest1020 |
      | cebeat | 0658209017 | Mireille509    |

