#Author: nihirk
@Cart

Feature: Cart



Scenario Outline: Validate the increase in quantity of item
Given User has added an item to the cart with quantity of <q> and is on cart page
When user clicks on plus button <n> number of times
Then the quantity of the particular item in the cart becomes q plus n
Examples:
|q|n|
|3|2|



Scenario Outline: Validate the decrease in quantity of item
Given User has added an item to the cart with quantity of <q> and is on cart page
When user clicks on minus button <n> number of times
Then the quantity of the particular item in the cart becomes q minus n
Examples:
|q|n|
|3|2|

