Feature: Login to the website to buy products
  Scenario: User not registered on the website
    Given  The user is on the website and wants to register
    When  Enter the login section of the website
    And select register new user
    And  Fill in the necessary fields for a successful registration
    Then DASHBOARD is shown
    And validate that the page title is correct


