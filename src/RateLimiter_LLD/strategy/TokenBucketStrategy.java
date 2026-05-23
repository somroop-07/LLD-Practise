package RateLimiter_LLD.strategy;

public class TokenBucketStrategy implements RateLimitingStrategy{

	int maxTokenCapacity;
	int refillTokensPerSecond;
	long lastRefilledTime;
	int tokens;
	
	public TokenBucketStrategy(int maxTokenCapacity, int refillTokens) {
		super();
		this.maxTokenCapacity = maxTokenCapacity;
		this.refillTokensPerSecond = refillTokens;
		lastRefilledTime = System.currentTimeMillis();
		tokens = maxTokenCapacity;
	}

	@Override
	public synchronized boolean allowRequest() {
		refill();
		if(tokens > 0) {
			tokens--;
			return true;
		
		}
		return false;
	}
	
	public void refill() {
		long now = System.currentTimeMillis();
		int tokensToAdd = (int)((now - lastRefilledTime)/1000) * refillTokensPerSecond;
		
		if(tokensToAdd > 0) {
		tokens = Math.min(tokens + tokensToAdd , maxTokenCapacity);
		lastRefilledTime = now;
		}
		
	}
	
	
	
}
