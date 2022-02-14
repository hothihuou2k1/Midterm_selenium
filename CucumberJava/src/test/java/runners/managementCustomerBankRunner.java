package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/Features"},
		glue = {"stepdefinitions"},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				tags = {"@ScenariOutlineExample"},
				dryRun = false,
				monochrome = true
		)
public class managementCustomerBankRunner {
	
}
