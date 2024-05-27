@activity1
Feature: "First Test"

@smokeTest
Scenario: Opening a webpage using Selenium
  Given User is on google homepage
  When  User types in Cheese and hits ENTER
  Then Show how many search results were shown
  And close the browser

