package RateLimiter_LLD.entitites;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {
   public static void main(String[] args) throws Exception {
	
	   RateLimiter rateLimiter = RateLimiterFactory.createRateLimiter("Token bucket");
//	   for(int i = 0; i < 10; i++) {
//		   boolean isAllowed = rateLimiter.rateLimit(new Request("xyz" + i, "123"));
//		   if(isAllowed) {
//			   System.out.println("Request allowed");
//		   }
//		   else {
//			   System.out.println("Request Blocked");
//		   }
//	   }
	   try {
		   AtomicInteger ans = new AtomicInteger(0);
		   ExecutorService executorService = Executors.newFixedThreadPool(10);
		   for(int t = 0; t < 10; t++) {
		   executorService.submit(()-> {
			   for(int i = 0; i < 100; i++) {
				   boolean isAllowed = rateLimiter.rateLimit(new Request("xyz" + i, "123"));
				   if(isAllowed) {
					   System.out.println("ThreadName: " + Thread.currentThread().getName() + " Request xyz" + i + " allowed");
					   ans.incrementAndGet();
				   }
				   else {
					   System.out.println("ThreadName: " + Thread.currentThread().getName() + " Request xyz" + i + " blocked");
				   }
			   }
			  
		   });
		   }
		   executorService.shutdown();

		   executorService.awaitTermination(
		           20,
		           TimeUnit.SECONDS
		   );
		   System.out.println(ans.get());
		   
//		Thread.sleep(1000);
//		for(int i = 0; i < 10; i++) {
//			boolean isAllowed = rateLimiter.rateLimit(new Request("xyz" + i, "123"));
//		   
//		if(isAllowed) {
//			   System.out.println("Request allowed");
//		   }
//		   else {
//			   System.out.println("Request Blocked");
//		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
