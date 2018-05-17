#Author: Yuri Felicio

Feature: Test Focuses and Skills on Curricula Page
  I want to use this template for my feature file

  
  Scenario Outline: Create a focus
    Given I want to add a focus
    When I add a focus with <name>
    Then I verify <name> has been added
    
  
  Scenario Outline: Edit a focus
    Given I want to edit a focus with <name>
    When I edit the focus to have <newname>
    Then I verify the focus has <newname>


  Scenario Outline: Create a skill
    Given I want to add a skill
    When I add a skill with <name>
    Then I verify <name> has been added
    