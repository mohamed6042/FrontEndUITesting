Feature: Test Login page
  Scenario: registered user can login to his account

    Given user click on Login page
    When  enter valid data
    And   click on "Log In" button
    Then  user is navigated to "My Account" page