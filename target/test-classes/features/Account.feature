Feature: Account
Background: Login
Given Login with Correct credentials



@Myaccount
Scenario: Verifying Myaccount section
When Clicking on Myaccount
Then Navigate to My account Page
Then Close driver



@Editaccount
Scenario: Verifying Edit account section
When Clicking on edit account
Then Navigate to edit details page
When Click on back
Then Navigate to My account Page
Then Close driver




@password
Scenario: Verifying password section
When clicking on password
Then Navigate to password page
When click on back btn
Then Navigate to My account Page
Then Close driver





@addressbook
Scenario: Verifying addressbook section
When clicking on adressbook
Then Navigate to adressbook page
When Clicking on back button
Then Navigate to My account Page
Then Close driver




@wishlist
Scenario: Verifying wishlist section
When clicking on wishlist
Then Navigate to wishlist page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver



@orderhistory
Scenario: Verifying orderhistory section
When clicking on order history
Then Navigate to order history page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver




@download
Scenario: Verifying downloads section
When clicking on downloads
Then Navigate to downloads page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver



@rewardpoints
Scenario: Verifying reward points section
When clicking on rewardpoints
Then Navigate to rewardpoints page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver



@returnexchange
Scenario: Verifying return for exchange section
When clicking on return for exchange
Then Navigate to return for exchange page
When Click on view button
Then Navigate to return information page
When Clicking on continue button in Account module
Then Navigate to return for exchange page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver



@transactions
Scenario: Verifying transaction section
When clicking on transactions
Then Navigate to transactions page
When Clicking on continue button in Account module
Then Navigate to My account Page
Then Close driver



@newsletter
Scenario: Verifying newsletter section
When clicking on newsletter
Then Navigating to newsletter page
When Clicking on back button
Then Navigate to My account Page
Then Close driver



@logout
Scenario: Verifying logout function
When clicking on logout
Then Navigate to logout page
When Clicking on continue button in Account module
Then Naviage to Uniform Store main page
Then Close driver