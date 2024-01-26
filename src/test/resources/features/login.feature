Feature: Validating Login Page

Scenario: Login with valid credentials
Given User has navigate to login page
When While entering valid Email "miniwilfred45@gmail.com"
And While entering valid Password "12345"
And By clicking login button
Then The user should be able to login successfully

Scenario Outline: Login with invalid credentials
Given User has navigate to login page
When While entering invalid Email <Email>
And While entering invalid Password <Password>
And By clicking login button
Then The user should not be able to login successfully
Examples:
|Email                | Password|
|sample1@gmail.com    | 12234   |
|sample2@gmail.com    | 12234   |
|sample3@gmail.com    | 12234   |
|sample4@gmail.com    | 12234   |


Scenario: Login without credentials
Given User has navigate to login page
When By clicking login button
Then The user should get a warning message



