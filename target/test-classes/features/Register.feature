@Register



Feature: Registration



Scenario: Verifying Register page with valid credentials.



Given Enter valid credentials
When Click on Continue.
Then Navigate to Account successfully created page.
And Click on Continue in Account Successfully created page.
And Navigated to the My Account page.




Scenario: Verifying Register page with already existing email.



Given Enter all the credentials along with already exisiting email.
When Click on Continue in Register page.
Then Warning message "The email already exists" will be displayed.




Scenario: Verifying the mandatory textfields



Given Enter all the mandatory textfields except one
When click Continue
Then Warning message should be displayed.




Scenario: Verifying the Privacy Policy element



Given Enter all the valid credentials without selecting the Privacy Policy element
When Click Continue button.
Then Warning message "You must agree to Privacy Policy" should be displayed.