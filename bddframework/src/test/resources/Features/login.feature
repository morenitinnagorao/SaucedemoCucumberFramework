Feature: Login functionality of Saucedemo

  Scenario: Valid login
    Given User is on login page
    When User enters valid username and password
    And User clicks on login button
    Then User should navigate to products page


  Scenario: Invalid login
    Given User is on login page
    When User enters invalid username and password
    And User clicks on login button
    Then Error message should be displayed
