Feature: Testing get request on the virgin game application

  @smoke
  Scenario: Check if the virgin application can be access by users
    When User sends a GET request to an list endpoint
    Then User must get back a valid status code i.e 200

  @smoke
  Scenario Outline: Verify the Bingo jackpots as per selected currency is changed or not
    When User sends a GET request to an list endpoint
    Then User must get back a valid status code 200 as per"<currency>"
    Examples:
      | currency |
      | SEK      |
      | GBP      |
      | EUR      |
