Feature: Task1_positive

  Scenario Outline: Post request to create token
    Given  Get payload from "<url>"
    Then  verify status code "<msg>"
    And  verify response contains token as key
    And  verify response contains header content type
    And  verify response contains token
    And  verify response Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/auth | 200 |




  Scenario Outline: Post request to create booking
    Given  Get payload from "<url>"
    Then  verify status code "<msg>"
    And  verify response contains bookingid as key
    And  verify response contains header content type
    And  verify response bookingid exist
    And  verify response Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/auth | 200 |
