@Smoke

Feature: user search for products

  Scenario Outline: user can search by productName
    When user enter "<productName>" in searchBox
    And  press search button
    Then user should find the "<productName>" in search result

      Examples:
        |productName|
        |book|
        |laptop|
        |nike|

  Scenario Outline: user can search by stock keeping unit
    When user enter "<SKU>" in searchBox
    And  press search button
    Then user should find the "<SKU>" in search details

      Examples:
        |SKU|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|


