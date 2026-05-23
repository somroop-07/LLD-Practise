package RateLimiter_LLD.entitites;

import RateLimiter_LLD.strategy.RateLimitingStrategy;
import RateLimiter_LLD.strategy.TokenBucketStrategy;

public class TokenRateLimiter extends RateLimiter {

	@Override
	public RateLimitingStrategy getRateLimitingStrategy() {
		return new TokenBucketStrategy(5, 2);
	}

}
