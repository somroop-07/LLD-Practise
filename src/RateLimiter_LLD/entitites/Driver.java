package RateLimiter_LLD.entitites;

public class Driver {
   public static void main(String[] args) throws Exception {
	
	   RateLimiter rateLimiter = RateLimiterFactory.createRateLimiter("Token bucket");
	   for(int i = 0; i < 10; i++) {
		   boolean isAllowed = rateLimiter.rateLimit(new Request("xyz" + i, "123"));
		   if(isAllowed) {
			   System.out.println("Request allowed");
		   }
		   else {
			   System.out.println("Request Blocked");
		   }
	   }
	   try {
		Thread.sleep(1000);
		for(int i = 0; i < 10; i++) {
			boolean isAllowed = rateLimiter.rateLimit(new Request("xyz" + i, "123"));
		   
		if(isAllowed) {
			   System.out.println("Request allowed");
		   }
		   else {
			   System.out.println("Request Blocked");
		   }
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
