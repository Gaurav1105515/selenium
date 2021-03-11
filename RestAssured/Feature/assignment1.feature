

Feature: Test success status of latest foreign exchange rates api
 

  
  
    Scenario: Success status of latest foreign exchnage api
    Given API for foreign exchange
    When posted with correct information
    Then validate positive response code received


