

Feature: Test success status of latest foreign exchange rates api
 

  
  
    Scenario: Success status of latest foreign exchnage api
    Given API For foreign exchange
    When pass valid values
    Then validate the response code received


