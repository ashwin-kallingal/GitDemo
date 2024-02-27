@tag
Feature: To Verify the Login Error Messages
  I want to use this template for my feature file
  
  Background:
 Given I landed on Ecommerce page

  @ErrorValidation
  Scenario Outline: To Verify the Login Page Error Message
    Given Logged in with username <name> and password <password>
    Then I verify the "Incorrect email or password." message is displayed in Login page.
    
    Examples: 
      | name                | password | 
      | ashwin555@gmail.com |Passw0rd& |