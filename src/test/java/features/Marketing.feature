Feature: Marketing



Background: Typing username and password
Given login with admin creditial
And Click on menu button and then Marketing
@Marketingdropdown
Scenario: Verifying the Marketing Functionality
When Click on Marketing
Then Navigate to Marketing page


When Click on Affiliates
Then Naviagte to Affiliates page


When click on Coupons
Then Navigate to Coupons page

When Click on Mail
Then Navigate to Mail page

@Marketingoption
Scenario: Verifying the Functionality in Marketing option
When Click on Marketing option
Then enter the Campaign Name in the campaign Name text box
And Click Filter


When Click on Add Button
Then Enter the Name in the Campaign text Box
Then Enter the Code in the Tracking code box
And Click on Save Button



@Affiliated
Scenario: Verifying the Functionality in Affiliated option
When Click on Affiliated
Then Enter the Name in the Affiliated name text box
Then Enter Mail in the Emails Text Box
And Click on Filtering

When Click on Affiliate option
Then Select the Check Box
And click on Deletebutton
And Click on Accept


@Coupons
Scenario: Verifying the Functionality in Coupons option
When Click on Couponsoptions
Then Click On Add Symbol
Then Click on Coupon Name
Then Click on Code
And Click on Save Option
And Click on Back option
Then Select the checkbox option
And Click on DeleteButton option
And Click on Accept option


@Mail
Scenario: Verifying the Functionality in Mail option
When Click on Mail option
Then Enter the Details in the From option
And Enter the Subject
And Click Mail Symbol
And click on Home

@Reports
Scenario: Verifying the Functionality in Reports option
When click on reportsdropdown
Then Click on Sales
Then Click on Order option
Then Navigate to Sales Report Page




When Click on Tax option
Then Navigate to Tax Report Page

Then Click on Shipping
And Navigate to Shipping Report

When Click on Returns option
Then Navigate to Returns Report

When Click on Coupons option
Then Navigate to Coupons Report

When Click on product
Then Click on Viewed
And Navigate to products Viewed Reports