
Feature: Validate all links on the documentation page 

 Scenario: Validate all links on the page for a provided URL
	Given User lanunches Browser
	When User navigates to the provided URL
	Then verify the status code of all links in the page
	And close the browser


      