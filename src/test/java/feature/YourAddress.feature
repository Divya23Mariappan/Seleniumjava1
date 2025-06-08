#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Your Address Option

  Scenario: Clicking on Address Module must navigate us to add address option.
    Given User must be signed in using valid uername, valid password 
    And should click on "sign in" to see "Hello <username>"  
    And User should mouse hover on "Hello <username>" to get options to choose from subslist 
    And User must select "Your account" from the options from the dropdwon list
    When User gets navigated to Your account page, User should click on "Your Address" option 
    Then User should be able to see "Add address" option
    
 Scenario: Clicking on Add Address should navigate to address window
  Given User must be signed in using valid uername, valid password 
    And should click on "sign in" to see "Hello <username>"  
    And User should mouse hover on "Hello <username>" to get options to choose from subslist 
    And User must select "Your account" from the options from the dropdwon list
    When User gets navigated to Your account page, User should click on "Your Address" option 
    And User should click able on "Add address" option
    Then User gets navigated to address window
  
     Scenario: Validate that the address form fields for Canada are properly filled and validated
    Given Country/Region must be auto-selected as "Canada"
    And Full Name field must be filled
    And Phone Number must be a valid 10-digit Canadian number
    And Address Line 1 must be filled
    And City must be filled with a valid Canadian city
    And Province must be selected from the dropdown
    And Postal Code must be a valid Canadian postal code
    When User submits the address form
    Then Address should be successfully saved