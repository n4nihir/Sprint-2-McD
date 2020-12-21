#Author: amit
@UserLocation

 

Feature: Location 

Background: User has allowed location access


Scenario: Validate the display of location at the top navbar
Given User has opened the website
When user searches for the location
And clicks done button
Then Selected location is displayed on the webpage


