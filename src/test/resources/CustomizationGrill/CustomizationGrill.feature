#Author: nihirk
@CustomizationGrill

Feature: CustomizationGrill



Scenario: Validate the addition of customizable items
Given User is on items page and adds a customizable item
When user chooses available customizations
And clicks the Add to Cart button
Then item is added to cart with the customizations



Scenario: Validate the removal of customizable items
Given User is on carts page and has added a customizable item with the customizations
When user clicks on Customize button and removes some customizations
And clicks Add to Cart
Then item is added to cart with the valid customizations


