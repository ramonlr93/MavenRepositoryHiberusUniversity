@cart
Feature: Cart test suite

  Background:
    Given the user is in the main page


  @testcase-14
  Scenario: Verify total price is correct
    When the user adds all items to the cart
    And the user goes to cart
    Then the total price should be the sum of the total of each product

  @testcase-15
  Scenario: Verify total price per product is correct
    When the user adds all items to the cart
    And the user goes to cart
    Then the total price of item in the multiplication between price and quantity

