Feature: User Registeration
   I want to check that the user can register in our e-commerce website.
   
   Scenario Outline: User Registeration
   Given the user in home page
   When I click on register link
   And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
   Then The registeration page displayed successfully
   
   Examples:
   
   | firstname | lastname | email | password |
   | ahelshal | morshedy | ahmkeor4sh2@gmail.com | 12355566 |
   | karimdd | elshadf | koqaei4ss@gmail.com | 695112222 |