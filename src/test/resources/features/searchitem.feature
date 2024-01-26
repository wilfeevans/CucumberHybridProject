Feature: Search Page Validation


Scenario: Search text box validation with valid search
Given User opens the application
When The user search with valid product called "hp"
And The user clicks on the search icon
Then The search results should get displayed

Scenario: Search text box validation with invalid search
Given User opens the application
When The user search with invalid product called "car"
And The user clicks on the search icon
Then The user should get a No Product Matches message


