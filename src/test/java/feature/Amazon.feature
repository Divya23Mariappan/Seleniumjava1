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

Feature: To check functionality of 'Already have an account? Sign in'

  Scenario: When user clicks on 'Already have an account? Sign in' user should be navigated to sign in page 
    Given User must be on Create account page "https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User clicks on 'Already have an account? Sign in'
    Then User should be navigated to sign in window 

   Scenario: When user enters invalid email ID and click continue user should get appropiate error message   
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters invalid email ID as Divy and click Continue
    Then User should get an appropriate error message 

Scenario: When user enters valid email ID and click continue user should get navigated to sign in window for password    
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters valid email ID as divya.spicerz@gmail.com and click Continue
    Then User should should get navigated to sign in window for password   
    
    Scenario: When user enters invalid password and click continue user should get appropiate error message   
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters valid email ID as divya.spicerz@gmail.com and click Continue And in password field enter inavlid password And click 'Sign in'   
    Then User should get an appropriate error message 
   
   Scenario: When user do not enter anything in password and click continue user should get appropiate error message   
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters valid email ID as divya.spicerz@gmail.com and click Continue And in password field do not enter anything And click 'Sign in'   
    Then User should get an appropriate error message 
    
    Scenario: When enter valid email and valid password and Selecting Keep me signed in checkbox, must let you to sign in without any further sign in
prompts on particular device 
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters valid email ID as "divya.spicerz@gmail.com" and click "Continue" And enter Valid password "Saravdiv@230990"  And click 'Sign in'  And User must select the "Keep me signed in " checkbox  
    Then It must let user to sign in without any further sign in prompts on particular device 
    
   Feature: To check functionality of 'Your Account' 
    
     Scenario: Customer must get message as Hello,Divya Account & lists.
    Given User must be on Sign in or create account page "https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=S9RWB3JKMA6D7S816AC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"
    When User enters valid email ID as "divya.spicerz@gmail.com" and click "Continue" And enter Valid password "Saravdiv@230990"  And click 'Sign in'  And User must select the "Keep me signed in " checkbox  
    Then Customer must get option as "Hello, Divya Accounts & lists" 
    
    
    
    
    
    
    
    
    
    
    
    
    
    