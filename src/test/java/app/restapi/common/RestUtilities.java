package app.restapi.common;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.response.Response;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;


public class RestUtilities {
	public static String ENDPOINT;
	public static RequestSpecBuilder REQUEST_BUILDER;
	public static RequestSpecification REQUEST_SPEC;
	public static ResponseSpecBuilder RESPONSE_BUILDER;
	public static ResponseSpecification RESPONSE_SPEC;
	PrintStream logStream;
	
	private static final Logger log = LogManager.getLogger(RestUtilities.class.getName());
	
	public RestUtilities() {
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		 logStream = IoBuilder.forLogger(log).buildPrintStream();
		 RestAssuredConfig restAssuredConfig = new RestAssuredConfig();
		 LogConfig logConfig = restAssuredConfig.getLogConfig(); 
		 logConfig
		 .defaultStream(logStream)
		 .enablePrettyPrinting(true);
		ResponseLoggingFilter.logResponseTo(logStream);
	}
	
	public void setEndPoint(String epoint) {
		ENDPOINT = epoint;
	}

	public RequestSpecification getRequestSpecificationBasicAuth(String baseURI, String bodyJson,String keyHeader, String headerValue) {
		log.info("The set the Request ");
		REQUEST_BUILDER = new RequestSpecBuilder() .addFilter(ResponseLoggingFilter.logResponseTo(logStream))
	            .addFilter(RequestLoggingFilter.logRequestTo(logStream));
		REQUEST_BUILDER.setBaseUri(baseURI);
		REQUEST_BUILDER.addHeader(keyHeader, headerValue);
		REQUEST_BUILDER.setBody(bodyJson);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}
	
	public RequestSpecification getRequestSpecificationBasicAuth(String baseURI) {
		log.info("The set the Request ");
		REQUEST_BUILDER = new RequestSpecBuilder() .addFilter(ResponseLoggingFilter.logResponseTo(logStream))
	            .addFilter(RequestLoggingFilter.logRequestTo(logStream));
		REQUEST_BUILDER.setBaseUri(baseURI);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}

	public ResponseSpecification getResponseSpecification(String user, String role, int statusCode ) {
		log.info("The set the Response");
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectStatusCode(statusCode);
		RESPONSE_BUILDER.expectResponseTime(lessThan(6L), TimeUnit.SECONDS);
		RESPONSE_BUILDER.expectBody("job", equalTo(role));
		RESPONSE_BUILDER.expectBody("name",equalTo(user));
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}
	
	public ResponseSpecification getResponseSpecification(int statusCode) {
		log.info("The set the Response");
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectStatusCode(statusCode);
		RESPONSE_BUILDER.expectResponseTime(lessThan(6L), TimeUnit.SECONDS);
		RESPONSE_BUILDER.expectBody("token", notNullValue() );
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}
	
	public ResponseSpecification getResponseSpecification(String fName,String lName ,String id,  int statusCode ) {
		log.info("The set the Response");
		int idInt =Integer.parseInt(id);	
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectStatusCode(statusCode);
		RESPONSE_BUILDER.expectResponseTime(lessThan(6L), TimeUnit.SECONDS);
		RESPONSE_BUILDER.expectBody("data.id", equalTo(idInt));
		RESPONSE_BUILDER.expectBody("data.first_name",equalTo(fName));
		RESPONSE_BUILDER.expectBody("data.last_name",equalTo(lName));
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}

	
	public Response getResponse(RequestSpecification reqSpec, ResponseSpecification respSpec ,String type) {
		REQUEST_SPEC.spec(reqSpec);
		Response response = null;
		
		switch(type) {
		case "get":
			response = given()
						.spec(REQUEST_SPEC)
						.when()
						.get(ENDPOINT);
			break;
		case "post":
			response = given()
						.spec(REQUEST_SPEC)
						.when()
						.post(ENDPOINT);
			break;
		case "put":
			response = given()
						.spec(REQUEST_SPEC)
						.when()
						.put(ENDPOINT);
			break;
		case "delete":
			response = given()
						.spec(REQUEST_SPEC)
						.when()
						.delete(ENDPOINT);
			break;
			default:
			log.info("Type is not supported");
			
		}
		response.then().spec(respSpec);
		return response;
	}
	
	
}
