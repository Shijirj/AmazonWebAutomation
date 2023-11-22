Feature: Shop at amazon


  Background: User in the Amazon homepage adds "2" Green Water Bottle to Cart
    Given the user is on the Amazon homepage
    And the user searches for "Green Water Bottle"
    And the user adds the first product appearing to Cart with quantity 2
@regression @smoke
  Scenario: Price and quantity of a product in Cart
    When the user opens the Cart
    Then the subtotal price in Cart should be correct
    And the quantity in Cart should be correct
  @regression
  Scenario: Reduce quantity of a product in Cart
    When the user opens the Cart
    And the user updates the quantity to 1 in Cart
    Then the quantity in Cart should be correct
    And the subtotal price in Cart should be correct