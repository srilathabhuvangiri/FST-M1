@activity4
Feature: "Login Test without example"


  Scenario: Testing Login without example
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message
    And Close the Browser

