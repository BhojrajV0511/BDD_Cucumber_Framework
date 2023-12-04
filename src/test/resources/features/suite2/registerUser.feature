Feature: Amazon Register User Functionality

  Scenario: Register a user
    Given amazon webpage is opened
    When user navigated to Account & List
    And clicked on Start here
    And entered name, mobile number, password
    And clicked to verify mobile number
    Then verify mobile number is displayed