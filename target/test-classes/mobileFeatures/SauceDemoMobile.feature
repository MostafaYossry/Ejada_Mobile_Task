#Author: mos.yossry.cufe@gmail.com
#Task for Ejada Company
#Mobile Scenario

Feature: SauceDemo Mobile App

# Invalid Logins
# I use different data using Scenario Outline and Examples to run same TC many times with different data
  Scenario Outline: Checking the login to Mobile App with invalid credentials (Data in Examples)
    Given I successfully connected to the mobile app
    When I need to add <Username> and <Password>
    And I Click on Login button
		Then I assert Not going to the Home Page without finding items
		
Examples: 
| Username 					| Password 			 |
| ""	 							| "secret_sauce" |
| "standard_user" 	| ""  				 	 |
| "locked_out_user" | "secret_sauce" |
| "Mostafa"				 	| "secret_sauce" |


# Valid Login
  Scenario Outline: Checking the login to Mobile App with valid credentials (Data in Examples)
    Given I successfully connected to the mobile app
    When I need to add <Username> and <Password>
    And I Click on Login button
		Then I assert the Home Page with finding items
		
Examples: 
| Username 					| Password 			 |
| "standard_user"		| "secret_sauce" |
