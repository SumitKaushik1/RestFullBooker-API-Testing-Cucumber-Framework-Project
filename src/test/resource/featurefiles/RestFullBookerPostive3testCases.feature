
Feature: Task_4_positive

Scenario Outline: Post request to create booking
Given  Get payload from urlTen "<url>"
Then  verify responseTen status code "<msg>"
And  verify  responseTen contains bookingId as key
And  verify  responseTen contains header content type
And  verify  responseTen contains bookingId
And  verify  responseTen Json Schema

Examples:
| url   | msg |
| https://restful-booker.herokuapp.com/booking | 200 |



  # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Delete request
    Given  delete bookingid  urlEleven "<url>"
    Then  verify responseEleven status code "<msg>"
    And  verify responseEleven contains header content type
    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 204 |