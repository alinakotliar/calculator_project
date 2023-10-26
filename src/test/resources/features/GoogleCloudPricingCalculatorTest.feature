Feature: Google Cloud Pricing Calculator

  Scenario: Calculate Estimated Monthly Cost and Verify via Email
    Given I am on "https://cloud.google.com/"
    When I search for "Google Cloud Platform Pricing Calculator"
    And I select "Google Cloud Platform Pricing Calculator" from the search results
    And I fill out the form with specific data
    And I generate a random email
    Then I send email with estimate cost
    And I verify that the emailed 'Total Estimated Monthly Cost' matches the result in the calculator