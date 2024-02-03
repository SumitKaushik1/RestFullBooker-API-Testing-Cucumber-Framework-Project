Feature: Task1_positive

  Scenario Outline: Post request to create token
    Given  Get payload from urlOne "<url>"
    Then  verify responseOne status code "<msg>"
    And  verify responseOne contains token as key
    And  verify responseOne contains header content type
    And  verify responseOne contains token
    And  verify responseOne Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/auth | 200 |


  Scenario Outline: Post request to create booking
    Given  Get payload from urlTwo "<url>"
    Then  verify responseTwo status code "<msg>"
    And  verify  responseTwo contains bookingId as key
    And  verify  responseTwo contains header content type
    And  verify  responseTwo contains bookingId
    And  verify  responseTwo Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |




