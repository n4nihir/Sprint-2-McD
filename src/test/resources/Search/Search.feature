#Author: amit
@Search

 

Feature: Search



Scenario: Validate that the list of relevant items appear
Given User has opened the website
When User clicks on the search box
And Enters the name of the item
Then Drop down list appears
And List of the relevant items appears


