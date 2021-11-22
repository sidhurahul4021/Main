Feature: My orders
Background: Login
Given Login with Correct credentials



@orderhistory
Scenario: Verifying View your order history
When clicking on view your order history
Then Navigate to Order history page
When Order is Placed
Then Display Order Id
When Click on view
Then Navigate to Order Information page
When Click on Return
Then Naviage to Return page
Then Checking the radio buttons and check boxes
When Click on submit
Then navigate to confirmation page
When Clicking on Continue button in My order
Then Naviage to Uniform Store main page
When Click on My account
Then Navigate to My account Page
When click on view your order history
Then Navigate to Order history page
When Clicking on Continue button in My order
Then Navigate to My account page
Then Close driver



@Downloads
Scenario: Verifying Downloads section
When Clicking on Downloads
Then Navigate to Downloads page
When Clicking on Continue button in My order
Then Navigate to My account Page
Then Close driver



@RewardPoints
Scenario: Verifying Your Rewards Section
When Clicking on Your Reward points
Then Navigate to Reward points page
When Clicking on Continue button in My order
Then Navigate to My account
Then Close driver



@return
Scenario: Verifying View your return requests
When Clicking on View your return requests
Then Navigate to Product returns page
When Clicking on Continue button in My order
Then Navigate to My account
Then Close driver



@Transactions
Scenario: Verifying Your Transactions
When Clicking on Your Transactions
Then Navigate to Transactions Page
When Clicking on Continue button in My order
Then Navigate to account page
Then Close driver



@recurring
Scenario: Verifying Recurring payments
When Clicking on recurring payments
Then Navigate to recurring payments page
When Clicking on Continue button in My order
Then Navigate to account page
Then Close driver