@activity4
Feature: Activity to test the login feature without examples


  @logintest
  Scenario: Test with correct Credentials
    Given the user is on login page
    When the user enters "admin" and "password"
    And clicks the login button
    Then get the confirmation text and verify
