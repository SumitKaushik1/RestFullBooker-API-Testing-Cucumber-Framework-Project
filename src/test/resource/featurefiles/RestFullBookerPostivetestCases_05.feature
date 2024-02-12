Feature: Task_5_Negative

  Scenario Outline: Post request to create token
    Given  Get payload from urlTwelve "<url>"
    Then  verify responseTwelve status code  "<msg>"
    And  verify responseTwelve contains token as key
    And  verify responseTwelve contains header content type
    And  verify responseTwelve contains token
    And  verify responseTwelve Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/auth | 200 |


  Scenario Outline: Post request with wrong text payload
    Given  Get payload from urlThirteen "<url>"
    Then  verify responseThirteen status code  "<msg>"

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 500 |
