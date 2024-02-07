Feature: Task_2_positive

  # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Delete request
    Given  delete bookingid  urlFive "<url>"
    Then  verify responseFive status code "<msg>"
    And  verify responseFive contains header content type
    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 204 |


     # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Get request for deleted user
    Given  Get bookingid  urlSix "<url>"
    Then  verify responseSix status code "<msg>"
    And  verify responseSix contains header content type
    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 404 |