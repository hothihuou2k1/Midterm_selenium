Feature: Manage Customer

  Scenario: Add Customer with valid data
  Given user is on manager page
  And verify manage page
  When user click on Add Customer button
  And user enter <firstname> and <lastname> and <postcode>
  And click Add on Customer button
  And click ok of alert box
  And verify data
  Then message is displayed
  
  Scenario: Add Customer with invalid data
  Given user is on manager page
  And verify manage page
  When user click on Add Customer button
  And user enter <firstname> and <postcode>
  And click Add on Customer button
  Then message is displayed
  
  Scenario: Open Account is successful
  Given user is on manager page
  And  verify manage page
  When user click on Open Account button
  And  select <account> and <currency>
  And  click on process button
  And  click ok of alert box
  Then message is displayed
  
  Scenario: Open Account is not successful
  Given user is on manager page
  And verify manage page
  When user click on Open Account button
  And select <account>
  And click on process button
  Then message is displayed
  
  Scenario: Search Account is successful
    Given user is on manager page
    And verify manage page
    When user click on Customer button
    And user search customer exist
    And verify search customer
    Then message is displayed

  Scenario: Search account does not exist
    Given user is on manager page
    And verify manage page
    When user click on Customer button
    And user search customer does not exist
    And verify search customer
    Then message is displayed
