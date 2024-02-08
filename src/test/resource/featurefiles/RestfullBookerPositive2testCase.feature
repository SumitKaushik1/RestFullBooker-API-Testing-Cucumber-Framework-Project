
Feature: Task_3_positive

  # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Get Request to get all booking
    Given  Get payload from urlSeven "<url>"
    Then  verify responseSeven status code "<msg>
    And  verify responseSeven contains header content type
    And  verify responseSeven contains bookingid
    And  verify responseSeven Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |


  # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Put Request to update  booking
    Given  Get payload from urlEight "<url>"
    Then  verify responseEight status code "<msg>
    And  verify responseEight contains header content type
    And  verify responseEight contains firstname
    And  verify responseEight Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |

      # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Get Request to get  bookingid
    Given  Get payload from urlNine "<url>"
    Then  verify responseNine status code "<msg>
    And  verify responseNine contains header content type
    And  verify responseNine contains firstname
    And  verify responseNine Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |