package app.stepdef;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.JsonParseException;

import app.datareader.RegresSetGet;
import app.restapi.RegresInOperations;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	RegresInOperations rio;
	RegresSetGet rsg;
	private static final Logger log = LogManager.getLogger(StepDefinition.class.getName());

	@Before
	public void before(final Scenario scenario) {
		log.info("The Test Suite " + StepDefinition.class.getName() + " has started");
		rio = new RegresInOperations();
		rsg = new RegresSetGet();
	}

	@Given("^I have the email (.*)$")
	public void i_have_the_email(String email) {
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 1 Read test data ------------------");
		rsg.setEmail(email);
		log.info("Read the email");
	}

	@Given("^I have the name (.*)$")
	public void i_have_the_name(String name) {
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 1 Read Test data ------------------");
		rsg.setName(name);
		log.info("Read the name");
	}

	@And("^I have the job (.*?)$")
	public void i_have_the_job(String job) {
		rsg.setJob(job);
		log.info("Read the job");
	}

	@And("^I have the keyHeader (.*?)$")
	public void i_have_the_keyHeader(String keyHeader) {
		rsg.setKeyHeader(keyHeader);
		log.info("Read the KeyHeader");
	}

	@And("^I have the headerValue (.*?)$")
	public void i_have_the_headerValue(String headerValue) {
		rsg.setHeaderValue(headerValue);
		log.info("Read the headerValue");
	}

	@And("^I have the id (.*?)$")
	public void i_have_the_id(String id) {
		rsg.setID(id);
		log.info("Read the id");
	}

	@And("^I have the lastname(.*?)$")
	public void i_have_the_lastname(String lastname) {
		rsg.setLastName(lastname.trim());
		log.info("Read the lastname");
	}

	@And("^I have the password (.*?)$")
	public void i_have_the_password(String password) {
		rsg.setPassword(password);
		log.info("Read the password");
	}

	@When("^I set the endpoint (.*?)$")
	public void i_set_the_endpoint(String endpoint) {
		rsg.setEndPoint(endpoint);
		log.info("Read the EndPoint");
	}

	@Then("^I can verify the status code (.*?)$")
	public void i_can_verify_the_status_code(int statusCode) throws JsonParseException, IOException {
		rsg.setStatusCode(statusCode);
		log.info("Read the Status Code");
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 2 Set Request ------------------");
		rio.setCreateAPI(rsg.getEmail(), rsg.getPassword(), rsg.getKeyHeader(), rsg.getHeaderValue(),
				rsg.getStatusCode(), rio.selectEndpoint(rsg.getEndPoint()));
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 3 Set and Verify Response ------------------");
		rio.readTheResponse("post");
		log.info("The response was validated");
	}

	@Then("^I can verify the status (.*?) to create resource$")
	public void i_can_verify_the_status_to_create_resource(int statusCode) throws JsonParseException, IOException {
		rsg.setStatusCode(statusCode);
		log.info("Read the Status Code");
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 2 Set Request ------------------");
		rio.setCreateAPI(rsg.getName(), rsg.getJob(), rsg.getKeyHeader(), rsg.getHeaderValue(), rsg.getStatusCode());
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 3 Set and Verify Response ------------------");	
		rio.readTheResponse("post");
		log.info("The response was validated");
	}

	@Then("^I can verify for a single user the status code (.*?)$")
	public void i_can_verify_for_a_single_user_the_status_code(int statusCode) throws JsonParseException, IOException {
		rsg.setStatusCode(statusCode);
		log.info("Read the Status Code");
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 2 Set Request ------------------");
		rio.setCreateAPI(rsg.getName(), rsg.getLastName(), rsg.getID(), rsg.getStatusCode());
		
		log.info("\n ----------------------------------------------------------------------");
		log.info(" -------------- Step 3 Set and Verify Response ------------------");
		rio.readTheResponse("get");
		log.info("The response was validated");
	}

	@After
	public void cleanUp(Scenario scenario) throws IOException, InterruptedException {
		log.info("The Test Steps " + StepDefinition.class.getName() + " have been completed");
		String stats = scenario.getStatus().toString();
		String method = scenario.getName();

		if (scenario.isFailed()) {
			log.error("======FAILED=====");
			ExtentCucumberAdapter.getCurrentStep().fail(method + " " + stats);

			scenario.write(stats);

		} else if (stats.equalsIgnoreCase("Passed")) {
			log.info("======PASSED=====");
		} else if (stats.equalsIgnoreCase("Skipped")) {
			log.info("======SKIPPED=====");
			ExtentCucumberAdapter.getCurrentStep().skip("Skipped: " + method);
			scenario.write(stats);
		} else if (stats.equalsIgnoreCase("Undefined")) {
			log.info("======UNDEFINED=====");
		}
	}

}
