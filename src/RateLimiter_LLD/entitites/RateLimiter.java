package RateLimiter_LLD.entitites;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import RateLimiter_LLD.strategy.RateLimitingStrategy;

public abstract class RateLimiter {
      Map<String, RateLimitingStrategy> rateLimitMap = new ConcurrentHashMap<>();

      
      public boolean rateLimit(Request request) {
    	  String clientId = request.getClientId();
    	  if(rateLimitMap.containsKey(clientId)) {
    		  return rateLimitMap.get(clientId).allowRequest();
    	  }
    	  RateLimitingStrategy strategy = this.getRateLimitingStrategy();
    	  rateLimitMap.put(clientId, strategy);
    	  return strategy.allowRequest();
      }
      
      public abstract RateLimitingStrategy getRateLimitingStrategy();
}
