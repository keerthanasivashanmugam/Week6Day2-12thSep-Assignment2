Feature: Update Incident functionality check in ServiceNow application

@functionality		@regression
Scenario: TC004_Delete Incident for positive functionality test

Given Select Number from the dropdown
And Enter the Incident number
And Click on the Incident Number link
When Click delete button
Then Verify the Incident is deleted

