package com.test.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = {"com.test.stepdefinitions" }, 
				monochrome = true, 
				plugin  = { "pretty", "html:target/cucumber-reports"})

public class TestRunner 
{
	
}