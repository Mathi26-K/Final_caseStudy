package Runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src//test//resources//Features//ConduitArticle.feature",
				glue= {"StepDefs"},
				monochrome = true,
				plugin = {"pretty",
				"html:target//Reports//HTMLreport.html",
				"usage:target//Reports//Usagereport",
				"json:target//Reports//JSONreport.json"})
			//	tags=not @PhaseOne and not @RegressionTest)
			
public class ConduitArticle extends AbstractTestNGCucumberTests {
	
		
	}

