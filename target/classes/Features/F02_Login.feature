@Smoke
Feature: user can login to their accounts

  Background:
    Given user go to login page

  Scenario: user could login with valid email and password
    When  user login with valid email "test@gmail.com" and password "123456789"
    And   user press on login button
    Then  user login to the system successfully

  Scenario: user can't login with invalid email and password
    When  user login with invalid email "wrongtest@gmail.com" and "123456789"
    And   user press on login button
    Then  user could not login to the system and error message is shown