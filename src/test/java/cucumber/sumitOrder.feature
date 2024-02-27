
@tag
Feature: Purchase the order from the Ecommerce Website
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce page


 @Regression
  Scenario Outline: Positive scenario of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    Then I verify the "THANKYOU FOR THE ORDER." message is displayed in Confirmation page.
    
    Examples: 
      | name                | password | productName    |
      | ashwin333@gmail.com |Passw0rd& | ADIDAS ORIGINAL|
      
