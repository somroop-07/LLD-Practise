package chain_of_responsibility_pattern;

public class Client {
	public static void main(String[] args) {
		CustomLogger logger = new InfoCustomLogger(new DebugCustomLogger(new ErrorCustomLogger(null)));
		   logger.log(LoggerType.ERROR,"Testing Logging error");
	}
   
}

//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 - github token (expires 22 Dec' 25)