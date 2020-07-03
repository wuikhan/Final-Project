package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature/Accounts.", 
glue = "stepDefinition", monochrome = true, dryRun = false)
public class TestRunner {

}
