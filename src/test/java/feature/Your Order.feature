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

Feature: Clicking on Your Order option Should navigate to Order history page 
Where one can view order placed in past. Like Past 3 months, this year or any archived order 

  Scenario: Checking functionality of Your order option
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin"
    When User mouse hover on Hello<username> Account & Lists 
    And clicks on your orders
    Then Should navigate to order history page where one can view order placed in past. Like Past 3 months, this year or any archived order

    Scenario: In Your Orders Module, one must get option of Buy Again, Not Yet Shipped, Cancelled orders.
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin" 
    And User mouse hover on Hello<username> Account & Lists  
     And clicks on your orders
    When Should navigate to order history page where one can view order placed in past. Like Past 3 months, this year or any archived order
    Then User must get option of Buy Again, Not Yet Shipped, Cancelled orders
    
    Scenario:  Clicking on "Buy Again" must give recommendation according to purchase history 
    In Your Orders Module, one must get option of Buy Again, Not Yet Shipped, Cancelled orders.
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin" 
    And User mouse hover on Hello<username> Account & Lists  
  And clicks on your orders
    When User should clicks on "Buy Again" 
    Then User recommendation according to purchase history should be displayed
    
     Scenario:  Clicking on "Buy Again" must give recommendation according to purchase history 
    In Your Orders Module, one must get option of Buy Again, Not Yet Shipped, Cancelled orders.
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin" 
    And User mouse hover on Hello<username> Account & Lists  
  And clicks on your orders
    When User should clicks on "Buy Again" 
    Then User recommendation according to purchase history should be displayed
    
     Scenario: Clicking on "Cancelled Orders" Must display any cancelled order in the past 6 months.
    In Your Orders Module, one must get option of Buy Again, Not Yet Shipped, Cancelled orders.
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin" 
    And User mouse hover on Hello<username> Account & Lists  
  And clicks on your orders
    When User should clicks on "Cancelled Orders" 
    Then any cancelled order in the past 6 months should be displayed
    
    Scenario: Clicking on "Not yet shipped" must display pending orders, else display appropriate 
message 
    Given User must be on Hello <username> Account & Lists Page url "https://www.amazon.ca/?ref_=nav_ya_signin" 
    And User mouse hover on Hello<username> Account & Lists  
  And clicks on your orders
    When User should clicks on "Not yet shipped" 
    Then It must display pending orders, else display appropriate 
    