$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CustomizationGrill.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: nihirk"
    }
  ],
  "line": 4,
  "name": "CustomizationGrill",
  "description": "",
  "id": "customizationgrill",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@CustomizationGrill"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Validate the addition of customizable items",
  "description": "",
  "id": "customizationgrill;validate-the-addition-of-customizable-items",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "User is on items page and adds a customizable item",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user chooses available customizations",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "clicks the Add to Cart button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "item is added to cart with the customizations",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefCustomizationGrill.user_is_on_items_page_and_adds_a_customizable_item()"
});
formatter.result({
  "duration": 33380862200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.user_chooses_available_customizations()"
});
formatter.result({
  "duration": 996107400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.clicks_the_Add_to_Cart_button()"
});
formatter.result({
  "duration": 157007400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.item_is_added_to_cart_with_the_customizations()"
});
formatter.result({
  "duration": 36917932800,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Validate the removal of customizable items",
  "description": "",
  "id": "customizationgrill;validate-the-removal-of-customizable-items",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "User is on carts page and has added a customizable item with the customizations",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user clicks on Customize button and removes some customizations",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "clicks Add to Cart",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "item is added to cart with the valid customizations",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefCustomizationGrill.user_is_on_carts_page_and_has_added_a_customizable_item_with_the_customizations()"
});
formatter.result({
  "duration": 39222730100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.user_clicks_on_Customize_button_and_removes_some_customizations()"
});
formatter.result({
  "duration": 11024310600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.clicks_Add_to_Cart()"
});
formatter.result({
  "duration": 108052000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCustomizationGrill.item_is_added_to_cart_with_the_valid_customizations()"
});
formatter.result({
  "duration": 15276314400,
  "status": "passed"
});
});n cart page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user clicks on minus button \u003cn\u003e number of times",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the quantity of the particular item in the cart becomes q minus n",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "cart;validate-the-decrease-in-quantity-of-item;",
  "rows": [
    {
      "cells": [
        "q",
        "n"
      ],
      "line": 23,
      "id": "cart;validate-the-decrease-in-quantity-of-item;;1"
    },
    {
      "cells": [
        "3",
        "2"
      ],
      "line": 24,
      "id": "cart;validate-the-decrease-in-quantity-of-item;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 24,
  "name": "Validate the decrease in quantity of item",
  "description": "",
  "id": "cart;validate-the-decrease-in-quantity-of-item;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@Cart"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "User has added an item to the cart with quantity of 3 and is on cart page",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user clicks on minus button 2 number of times",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the quantity of the particular item in the cart becomes q minus n",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 52
    }
  ],
  "location": "StepDefCart.user_has_added_an_item_to_the_cart_with_quantity_of_and_is_on_cart_page(int)"
});
formatter.result({
  "duration": 60902316900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 28
    }
  ],
  "location": "StepDefCart.user_clicks_on_minus_button_number_of_times(int)"
});
formatter.result({
  "duration": 15269564000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefCart.the_quantity_of_the_particular_item_in_the_cart_becomes_q_minus_n()"
});
formatter.result({
  "duration": 10151944800,
  "status": "passed"
});
});