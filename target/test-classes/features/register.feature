Feature: Validating Registration Page

Scenario: Validating all the Registration fields
Given User navigates to the Registration Account Page
When The user enter the all the below fields:
|firstname|Arun|
|LastName|Sam|
|Telephone|9834348738|
|Password|A12323|
|Password Confirm|A12323|
And Checking the privacy policy
And User clicks on continue button
Then The user should be able to register successfully

Scenario: User creates an account without filling the registration details
Given User navigates to the Registration Account Page
When The user is not entering any of the mandatory fields
And The user clicks on the continue button
Then The user should thrown with warning messages


 

