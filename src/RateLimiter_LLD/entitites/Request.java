package RateLimiter_LLD.entitites;

import java.util.UUID;

public class Request {
     String requestId;
     String clientId;
     String requestBody;
 
       
     public Request(String requestBody, String clientId) {
		requestId = UUID.randomUUID().toString();
		this.clientId = clientId;
		this.requestBody = requestBody;
	}


	 public String getClientId() {
		 return clientId;
	 }


	 public String getRequestBody() {
		 return requestBody;
	 }


	 


     
}
