package app.restapi;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;

import app.restapi.common.ConfigReader;
import app.restapi.common.Path;
import app.restapi.common.RestUtilities;
import app.restapi.common.JSONBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RegresInOperations {
	ConfigReader config = new ConfigReader();
	RestUtilities restUt;
	JSONBuilder jsonb;
	RequestSpecification reqSpec;
	ResponseSpecification respSpec;
	private static final Logger log = LogManager.getLogger(RegresInOperations.class.getName());

	public RegresInOperations() {
		restUt = new RestUtilities();
		jsonb = new JSONBuilder();
	}

	public String selectEndpoint(String endPoint) {
		String endP = null;
		switch (endPoint) {
		case "Users":
			endP = Path.ENDPOINT_USERS;
			log.info("The endpoint is: "+ Path.ENDPOINT_USERS);
			break;
		case "Login":
			endP = Path.ENDPOINT_LOGIN;
			log.info("The endpoint is: "+ Path.ENDPOINT_LOGIN);
			break;
		}
		return endP;
	}
	
	public void setCreateAPI(String user, String role, String keyHeader, String headerValue, int statusCode)
			throws JsonParseException, IOException {
		String bodyJsonGroup = "{  \"name\": \"" + user + "\" ,  \"job\": \"" + role + "\"}";
		log.info("String JSON: " + bodyJsonGroup);
		String json = jsonb.stringTJSON(bodyJsonGroup);
		log.info("JSON: " + json);
		restUt.setEndPoint(Path.ENDPOINT_USERS);
		
		reqSpec = restUt.getRequestSpecificationBasicAuth(Path.BASE_URI, json, keyHeader, headerValue);
		respSpec = restUt.getResponseSpecification(user, role, statusCode);
	}
	
	public void setCreateAPI(String user, String role, String keyHeader, String headerValue, int statusCode, String endPoint)
			throws JsonParseException, IOException {
		String bodyJsonGroup = "{  \"email\": \"" + user + "\" ,  \"password\": \"" + role + "\"}";
		log.info("String JSON: " + bodyJsonGroup);
		String json = jsonb.stringTJSON(bodyJsonGroup);
		log.info("JSON: " + json);
		restUt.setEndPoint(endPoint);
		
		reqSpec = restUt.getRequestSpecificationBasicAuth(Path.BASE_URI, json, keyHeader, headerValue);
		respSpec = restUt.getResponseSpecification(statusCode);
	}
	
	public void setCreateAPI(String fName,String lName ,String id, int statusCode) {
		restUt.setEndPoint(Path.ENDPOINT_USERS+"/"+id);
		reqSpec = restUt.getRequestSpecificationBasicAuth(Path.BASE_URI);
		respSpec = restUt.getResponseSpecification(fName,lName ,id, statusCode);
	}
	

	public void readTheResponse(String responseType) {
		Response res = restUt.getResponse(reqSpec, respSpec, responseType);
		String text = res.asString();
		log.info("The response is: " + text);
	}

}
