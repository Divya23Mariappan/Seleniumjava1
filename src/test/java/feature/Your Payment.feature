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
Feature: Your payments module 
  Scenario: Customer must be allowed to add payment method
    Given User must be in the Amazon home page 
    And mouse hover on hello sign in 
    And click your account 
    When in the Your account page user should click your payments 
    Then cx must be able to add payment method by clicking on add payment method

 
  Scenario: Customer must be allowed to add a new card details in the add payment method 
    Given User must be in the Amazon home page 
    And mouse hover on hello sign in 
    And click your account 
  When in the Your account page user should click your payments 
     Then cx must be able to add his new card details in the add payment method