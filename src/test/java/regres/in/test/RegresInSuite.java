package regres.in.test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;

import app.restapi.RegresInOperations;
import app.restapi.common.Path;



public class RegresInSuite {
    RegresInOperations rio;

	private static final Logger log = LogManager.getLogger(RegresInSuite.class.getName());
	
	
	
	
	@BeforeMethod
	public void setClasses() {
		log.info("The Test Suite " + RegresInSuite.class.getName() + " has started");
		rio = new RegresInOperations();
	
	}

  @Test
  public void testRestAPI() throws JsonParseException, IOException {
	  rio.setCreateAPI("morpheus", "leader","Content-Type","application/json", 201);
	  rio.readTheResponse("post");
	  
  }
  
  

  @Test
  public void testRest2API() throws JsonParseException, IOException {
	  rio.setCreateAPI("Michael", "Lawson","7", 200);
	  rio.readTheResponse("get");
	  
  }
  
  
  @Test
  public void testRest3API() throws JsonParseException, IOException {
	  rio.setCreateAPI("eve.holt@reqres.in", "cityslicka","Content-Type","application/json", 200, Path.ENDPOINT_LOGIN);
	  rio.readTheResponse("post");
	  
  }
  
}
