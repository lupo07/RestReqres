package app.test.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { 	"pretty",
		"html:target/cucumber-html-report",
		"json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = {"features"}, 
monochrome=true,
glue = "app.stepdef" )
public class RegresINRunTest {

}