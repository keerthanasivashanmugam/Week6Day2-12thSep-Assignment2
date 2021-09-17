Feature: Assign Incident functionality check in ServiceNow application

@functionality
Scenario: TC002_Assign Incident for positive functionality test

Given Search for the Incident number in the dropdown by using Number option
And Click the Incident number link
And Click on the Assignment group Lookup
And Enter 'Software' in the search box of the child window and select the group
And Click on Work Notes and enter 'Work Notes'
When Click on Update button
Then Verify whether the Assignment group is software
