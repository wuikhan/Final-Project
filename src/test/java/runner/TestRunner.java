package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", glue = "stepDefinition", tags="@test", monochrome = true, dryRun = false)
public class TestRunner {

}
