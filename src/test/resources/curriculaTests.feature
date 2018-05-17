#Author: Yuri Felicio
Feature: Test Focuses and Skills on Curricula Page
  I want to use this template for my feature file
  
  Scenario Outline: Edit a focus
    Given I want to edit a focus with <name>
    When I edit the focus to have <newname>
    Then I verify the focus has <newname>

  Examples:
	|name|newname|
	|sql | nosql |
	