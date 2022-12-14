
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on  Ecommerce page

  @tag2
  Scenario: Postivie Test for Submitting order
    Given login with username and password
    And Adding products to cart page
    When checking out
    And Filling details and placing order
    Then  conformation message
  