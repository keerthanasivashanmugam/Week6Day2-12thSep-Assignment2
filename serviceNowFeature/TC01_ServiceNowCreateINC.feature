Feature: Create Incident functionality check in ServiceNow application

@functionality	@regression
Scenario Outline: TC001_Creating multiple Incidents for positive functionality test

Given Click on Create New option and save the Incident number
And Enter <CallerName> and <ShortDescription>
And Click on Submit button
When Search for the Created Incident number in the dropdown by using Number option
Then Verify whether the Incident number is displayed

Examples:
|CallerName|ShortDescription|
|'Krystle Stika'|'Sample INC'|
