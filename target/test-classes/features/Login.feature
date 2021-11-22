Feature: MyAccount



Scenario Outline: Verify MyAccount page is opening when clicking on Login
Given Navigating to our website
And Login with <username> and <password>
When Click on to MyAccount
Then It should Navigate to My Account 



Examples:
|username |password |
|abhignya7@gmail.com |Abhignya123 |
|abhignya7@gmail.com| abc|
|abc|Abhignya123|
|abc|xyz|