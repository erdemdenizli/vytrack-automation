Feature: Application Login

Background:
Given initialize the driver with "chrome"

Scenario Outline: Positive test validating login

Given user is on "http://qa2.vytrack.com/user/login"
When user enters valid <username> and <password>
Then verify that user is logged in and "Dashboard" is displayed
And close the driver

Examples:
|username   	|password     	|
|user7			|UserUser123	|
|storemanager55 |UserUser123	|
|salesmanager107|UserUser123	|

Scenario Outline: Negative test validating not logging in

Given user is on "http://qa2.vytrack.com/user/login"
When user enters invalid <username> and <password>
Then verify that user is not logged in and page title is "Login"
And "Invalid user name or password." message pops up
And close the driver

Examples:
|username   	|password     	|
|user7			|UserUser1		|
|storemanager55	|UserUser1		|
|salesmanager10	|UserUser123	|