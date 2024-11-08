
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with useremail <email> and password <password>
    When I add product <product> to Cart
    And Checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | email                  | password        | product     |
      | vipigo8970@acroins.com | mohammedZain@33 | ZARA COAT 3 |
   
