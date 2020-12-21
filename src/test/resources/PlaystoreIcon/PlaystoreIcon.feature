#Author: amit
@PlayStoreIcon

 

Feature: PlaystoreIcon

 

Scenario: Validate that the new tab opens the play store page upon clicking the play store icon
Given User has opened the website
When User clicks on the play store icon
Then Navigate to Playstore page in a new tab
And McDelivery app download page is displayed


