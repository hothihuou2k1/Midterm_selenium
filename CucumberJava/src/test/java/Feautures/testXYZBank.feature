Feature: to manage customers on YXZBank page

  Scenario: add a customer with valiad data 
  Given user move to the management customer
  And  verify to the management page
  When the user click on add customer button
  And user enter <firstName> and <lastName> and <code> 
  And click add on customer button
  And user click to OK of the alert box
  And verify to data
  Then display the message
  
  Scenario: add a customer with invaliad data 
  Given user move to the management customer
  And verify to the management page
  When the user click on add customer button
  And user enter <lastName> and <code>
  And click add on customer button
  Then display the message
  
  Scenario: open an account is successful
  Given user move to the management customer 
  And verify to the management page
  When user click on open an account button
  And user to select <account> and <currency>
  And user click on the process button
  And user click to OK of the alert box
  Then display the message
  
  Scenario: open an account is not successful
  Given user move to the management customer 
  And verify to the management page
  When user click on open an account button
  And user to select <account>
  And user click on the process button
  Then display the message
  
  Scenario: search an account is successful
    Given user move to the management customer
    And verify to the management page
    When user click on Customer button
    And user to search customer is exist
    And verify to search customer
    Then display the message

  Scenario: search an account is not exist
    Given user move to the management customer 
    And verify to the management page
    When user click on Customer button
    And user to search customer is not exist
    And verify to search customer
    Then display the message
