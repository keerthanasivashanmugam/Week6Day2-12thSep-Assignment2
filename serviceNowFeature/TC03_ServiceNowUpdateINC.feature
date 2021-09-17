Feature: Update Incident functionality check in ServiceNow application

@functionality	
Scenario: TC003_Update Incident for positive functionality test

Given Select the Number option from the dropdown and enter the IncidentNumber
And Click on the Incident number link
And Click on lookup and select the 'urgency' as '1'
And Click on lookup and select the 'state' as '2'
And Click on Update button
And Click on the Incident number link
When Get the Urgency and State values
Then Verify Urgency and State are updated
