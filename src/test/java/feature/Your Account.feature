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
Feature: Checking the functionality of Your Account  
Scenario: One must be able to click on it or mouse hover on "Hello <username>" Account & Lists and choose options from sub list
    Given User must be signed in using valid uername, valid password 
    And should click on "sign in" to see "Hello <username>"  
    When User should mouse hover on "Hello <username>" 
    Then Customer must get options to choose from subslist 
    
  