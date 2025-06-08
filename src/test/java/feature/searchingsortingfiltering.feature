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
Feature: Product Search Facility
  
  Scenario: Ability to search on keyword, description text, partial item text, item number, partial item number
and/or category keyword 
    Given User should be in homepage 
    When User enters "<searchTerm>" in the search box
    And clicks on the search button
    Then Products matching "<searchTerm>" should be displayed in the results

  
    Examples: 
      | searchTerm        |         
      | gaming headset    |
      | 1234              |
      | 56AB              |
      | electronics       |
      | shoe              |
      
    Scenario: Search for a product with partial text
    When User enters "lap" in the search box
    And clicks on the search button
    Then Products containing "lap" in name, description, or item number should be displayed
    
    Scenario: Search for a product that does not exist
    When User enters "xyznotfound" in the search box
    And clicks on the search button
    Then A message "No products found" should be displayed
    
    
