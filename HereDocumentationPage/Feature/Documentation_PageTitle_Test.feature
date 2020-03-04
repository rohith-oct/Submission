Feature: Validate the title on the documentation page 


		
		
 Scenario: Validating page title for a given URL
    Given User lanunches Browser
    When User navigates to the provided URL
    Then Validating the page title
    And close the browser