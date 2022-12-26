@Smoke
Feature: user can switch to another currency of the products

  Scenario: user switch from USD currency to euro currnecy
    When  select  euro from currency dropdown
    Then  prices of the products will be with €