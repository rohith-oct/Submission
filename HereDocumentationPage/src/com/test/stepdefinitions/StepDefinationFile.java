package com.test.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.page.objects.AppConstants;

import com.page.objects.LoginPage;

public class StepDefinationFile extends LoginPage {

	
	
	  
	  
	  @Given("^User lanunches Browser$") public void user_lanunches_Browser()
	  throws Throwable { getBrowser(); }
	 

	@When("^User navigates to the provided URL$")
	public void user_navigates_to_the_provided_URL() throws Throwable {
		launchURL(AppConstants.URL);
	}

	@Then("^Validating the page title$")
	public void validating_the_page_title() throws Throwable {
	   System.out.println(driver.getTitle());
		Assert.assertEquals(AppConstants.ExpectedTitle, driver.getTitle());
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	   driver.close();
	}
	
	@Then("^verify the status code (\\d+) of Page$")
	public void verify_the_status_code_of_Page(int arg1) throws Exception {
		
		System.out.println(statusCodeforLoginPage(AppConstants.URL));
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertEquals(AppConstants.ExpectedResponseCode, statusCodeforLoginPage(AppConstants.URL));
	}
	
	

	
	@Then("^verify the status code of all links in the page$")
	public void verify_the_status_code_of_all_links_in_the_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		verifyAllLinks(AppConstants.Links_XPATH);
	    verifyAllLinks(AppConstants.DropDownLinks_XPATH);
	}
	
	
}


	

