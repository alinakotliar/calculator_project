Scenario: Calculate Total Estimated Cost
Given I am on the Google Cloud home page
When I search for "Google Cloud Platform Pricing Calculator"
And I click on the Calculator link
And I fill out the calculator form
And I click the "Add to Estimate" button
And I open a new tab and navigate to "https://yopmail.com/"
And I generate a random email
And I return to the calculator page
And I enter the generated email into the email field
And I click the "Send Email" button
And I switch to the YopMail tab
Then I should see the emailed "Total Estimated Monthly Cost" matching the calculator result