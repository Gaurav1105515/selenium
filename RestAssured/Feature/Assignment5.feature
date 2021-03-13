
Feature: RestAssured negative scenario and response logging
 

  @tag1
  Scenario: check the respoonse for negative scenario
    Given API For foreign Exchange
    
    When Posted With correct Information
   
    
    Then validate  the positive response code received
   

  
