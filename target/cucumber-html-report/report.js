$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("End2End_Tests.feature");
formatter.feature({
  "line": 1,
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of the feature is to test End integration.",
  "id": "automated-end2end-tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he search for \"\u003cproductName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "move to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;",
  "rows": [
    {
      "cells": [
        "productName"
      ],
      "line": 13,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;1"
    },
    {
      "cells": [
        "Apple MacBook Pro 13-inch"
      ],
      "line": 14,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he search for \"Apple MacBook Pro 13-inch\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose to buy Two items",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "move to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.match({
  "location": "E2ETests.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 201418700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Apple MacBook Pro 13-inch",
      "offset": 15
    }
  ],
  "location": "E2ETests.he_search_for(String)"
});
formatter.result({
  "duration": 9216899354,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.choose_to_buy_Two_items()"
});
formatter.result({
  "duration": 5343489692,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()"
});
formatter.result({
  "duration": 16732824767,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.he_can_view_the_order_and_download_the_invoice()"
});
formatter.result({
  "duration": 7354196014,
  "status": "passed"
});
formatter.uri("UserRegisteration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registeration",
  "description": " I want to check that the user can register in our e-commerce website.",
  "id": "user-registeration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User Registeration",
  "description": "",
  "id": "user-registeration;user-registeration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"\u003cfirstname\u003e\" , \"\u003clastname\u003e\" , \"\u003cemail\u003e\" , \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registeration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "user-registeration;user-registeration;",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "email",
        "password"
      ],
      "line": 12,
      "id": "user-registeration;user-registeration;;1"
    },
    {
      "cells": [
        "ahelshal",
        "morshedy",
        "ahmkeor4sh2@gmail.com",
        "12355566"
      ],
      "line": 13,
      "id": "user-registeration;user-registeration;;2"
    },
    {
      "cells": [
        "karimdd",
        "elshadf",
        "koqaei4ss@gmail.com",
        "695112222"
      ],
      "line": 14,
      "id": "user-registeration;user-registeration;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "User Registeration",
  "description": "",
  "id": "user-registeration;user-registeration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"ahelshal\" , \"morshedy\" , \"ahmkeor4sh2@gmail.com\" , \"12355566\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registeration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegisteration.the_user_in_home_page()"
});
formatter.result({
  "duration": 680921663,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.i_click_on_register_link()"
});
formatter.result({
  "duration": 5070696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ahelshal",
      "offset": 11
    },
    {
      "val": "morshedy",
      "offset": 24
    },
    {
      "val": "ahmkeor4sh2@gmail.com",
      "offset": 37
    },
    {
      "val": "12355566",
      "offset": 63
    }
  ],
  "location": "UserRegisteration.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 2813658248,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.the_registeration_page_displayed_successfully()"
});
formatter.result({
  "duration": 1082444881,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "User Registeration",
  "description": "",
  "id": "user-registeration;user-registeration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"karimdd\" , \"elshadf\" , \"koqaei4ss@gmail.com\" , \"695112222\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registeration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegisteration.the_user_in_home_page()"
});
formatter.result({
  "duration": 685432559,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.i_click_on_register_link()"
});
formatter.result({
  "duration": 11628345,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "karimdd",
      "offset": 11
    },
    {
      "val": "elshadf",
      "offset": 23
    },
    {
      "val": "koqaei4ss@gmail.com",
      "offset": 35
    },
    {
      "val": "695112222",
      "offset": 59
    }
  ],
  "location": "UserRegisteration.i_entered(String,String,String,String)"
});
formatter.result({
  "duration": 1734015356,
  "status": "passed"
});
formatter.match({
  "location": "UserRegisteration.the_registeration_page_displayed_successfully()"
});
formatter.result({
  "duration": 1095197102,
  "status": "passed"
});
});