@activity2
Feature: Activity to test the login feature

  @logintest
  Scenario: Successful Login
    Given the user is on login page
    When the user enters username and password
    And clicks the login button
    Then get the confirmation text and verify

