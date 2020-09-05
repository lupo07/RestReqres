package app.restapi.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONBuilder {

	public  String stringTJSON(String stringJSON) 
			  throws JsonParseException, IOException { 
			    ObjectMapper mapper = new ObjectMapper();
			    JsonNode actualObj = mapper.readTree(stringJSON);
			 return stringJSON;
			}
	
}
