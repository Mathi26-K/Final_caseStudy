package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src//test//resources//Features//ConduitArticle.feature",
				glue= {"StepDefs"},
				monochrome = true,
				plugin = {"pretty",
				"html:target//Reports//HTMLreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
			
			
public class ConduitArticle extends AbstractTestNGCucumberTests {
	
		
	}

