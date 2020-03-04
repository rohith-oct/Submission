Feature: Validate status code of a page after launching the URL
	
Scenario Outline:
Validate status code of a page for a provided URL
 Given User lanunches Browser
   When User navigates to the provided URL
	Then verify the status code <Status Code> of Page
And close the browser 	
	
	Examples: 
		|Status Code|
		|200|