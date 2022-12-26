@Smoke
Feature:  users could register with new accounts
  Scenario: user register with valid data

    Given user navigate to registration page
    When  user select gender type
    And   enter firstname "Mohamed" and lastname "Mahmod"
    And   user enter date of birth
    And   user enter email "test@gmail.com" field
    And   user enter companyname
    And   user enter password
    And   click "register" button
    Then  success message is displayed


