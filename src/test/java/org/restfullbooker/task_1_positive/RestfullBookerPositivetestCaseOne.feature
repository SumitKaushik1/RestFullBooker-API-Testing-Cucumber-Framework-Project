Feature: Task1_positive

  Scenario Outline: Post request to create token
    Given  Get payload from "<url>"
    Then  verify responseOne status code "<msg>"
    And  verify responseOne contains token as key
    And  verify responseOne contains header content type
    And  verify responseOne contains token
    And  verify responseOne Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/auth | 200 |




