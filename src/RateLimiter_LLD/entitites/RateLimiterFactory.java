package RateLimiter_LLD.entitites;

public class RateLimiterFactory {
    
	public static RateLimiter createRateLimiter(String type) throws Exception {
		if(type.equalsIgnoreCase("Token Bucket")) {
			return new TokenRateLimiter();
		}
		throw new Exception("Invalid algorithm");
	}
}
