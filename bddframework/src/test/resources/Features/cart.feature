Feature: Add product to cart

  Background:
    Given User is on login page
    When User enters valid username and password
    And User clicks on login button

  Scenario: Add product successfully
    When User adds product to cart
    Then Product should be visible in cart
