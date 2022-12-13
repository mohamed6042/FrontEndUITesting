Feature: user can register
  Scenario: user register with valid data

    Given user navigate to registration page
    When  enter valid First name, Last name, Email, password and Confirm password
    And   click "register" button
    Then  a message should be shown as "Your registration completed"