Feature: Naukri

  Scenario: Do cv upload
    Given Open naukri website
    When user login to naukri.com
    And user navigate to profile page
    And user uploads cv
    Then Verify "Success" message is displayed