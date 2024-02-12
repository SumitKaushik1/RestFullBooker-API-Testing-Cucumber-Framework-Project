
Feature: Task_6_Negative

  # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Get Request to get all booking
    Given  Get payload from urlfourteen "<url>"
    Then  verify responsefourteen status code "<msg>
    And  verify responsefourteen contains header content type
    And  verify responsefourteen contains bookingid
    And  verify responsefourteen Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |

    # one scenerio is like sending one request and getting the response and test it
  Scenario Outline: Put Request to update  booking
    Given  Get payload from urlfifeteen "<url>"
    Then  verify responsefifeteen status code "<msg>
    And  verify responsefifeteen contains header content type
    And  verify responsefifeteen contains firstname
    And  verify responsefifeteen Json Schema

    Examples:
      | url   | msg |
      | https://restful-booker.herokuapp.com/booking | 200 |