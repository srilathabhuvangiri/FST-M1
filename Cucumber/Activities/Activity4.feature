@activity4
Feature: Data driven test without Example


  Scenario: esting with Data from Scenario
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message
    And Close the Browser

