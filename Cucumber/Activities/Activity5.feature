@activity5
Feature: Activity to test the login feature WITH examples


  @logintestwithExamples
  Scenario Outline: Test with correct Credentials
    Given the user is on login page
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then get the confirmation text and verify
    Examples:
      |  username|  password |
      |  admin   |  password |
      |  adminUser  |  Password |

