package RateLimiter_LLD.entitites;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import RateLimiter_LLD.strategy.RateLimitingStrategy;

public abstract class RateLimiter {
      Map<String, RateLimitingStrategy> rateLimitMap = new ConcurrentHashMap<>();

      
      public boolean rateLimit(Request request) {
    	  String clientId = request.getClientId();
    	  RateLimitingStrategy strategy = rateLimitMap.computeIfAbsent(clientId, k -> getRateLimitingStrategy());
    	  return strategy.allowRequest();
      }
      
      public abstract RateLimitingStrategy getRateLimitingStrategy();
}
