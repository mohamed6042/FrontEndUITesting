@Smoke

  Feature: user can add products to WishList
    Background:
      When user click on "add to wishlist" button of any product

    Scenario: select a product to add in wishlist

      Then a successful message is shown to user

    Scenario: user check wishlist after adding a product
      And  go to wishlist page
      Then the product is been added in wishlist page with quantity=1