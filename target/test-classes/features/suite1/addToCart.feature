Feature: Amazon add to cart functionality

  Scenario: Add a product to cart
    Given I am on the Amazon webpage
    When user searched iphone
    And selected an iphone from list and navigated to product details page
    And select and store price in a variable
    And added it to cart
    Then product should be added to cart
