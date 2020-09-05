package app.datareader;

public class RegresSetGet {
	
    private String email;
    private String password;
    private String keyHeader;
    private String headerValue;
    private String endPoint;
    private int statusCode;
	private String name;
	private String job;
	private String lastname;
	private String id;
    
   
	 public void setID(String id) {
	        this.id = id;
	    }
	
    public void setEmail(String username) {
        this.email = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }    
   
    public void setKeyHeader(String keyHeader) {
        this.keyHeader = keyHeader;
    }
    
    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }
    
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
    
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getKeyHeader() {
        return keyHeader;
    }
    
    public String getHeaderValue() {
        return headerValue;
    }
    
    public String getEndPoint() {
        return endPoint;
    }
    public int getStatusCode() {
        return statusCode;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getLastName() {
    	return lastname;
    }
    
    public String getJob() {
    	return job;
    }
    
    public String getID() {
    	return id;
    }
}
