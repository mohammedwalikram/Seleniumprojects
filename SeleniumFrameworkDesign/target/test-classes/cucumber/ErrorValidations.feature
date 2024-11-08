
@tag
Feature: ErrorValidations
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with useremail <email> and password <password>
    Then "Incorrect email or password." error message is displayed

    Examples: 
      | email                  | password         |
      | vipigo8970@acroins.com | mohammedzzain@33 |