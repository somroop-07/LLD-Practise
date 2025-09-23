package chain_of_responsibility_pattern;

public abstract class CustomLogger {
	
	CustomLogger nextLogger;
	CustomLogger(CustomLogger nextLogger){
		this.nextLogger = nextLogger;
	}
	
	public void log(LoggerType type, String message) {
		if(nextLogger != null) {
			nextLogger.log(type, message);
		}
	}

}

class InfoCustomLogger extends CustomLogger{

	InfoCustomLogger(CustomLogger nextLogger) {
		super(nextLogger);

	}

	@Override
	public void log(LoggerType type, String message) {
		if(type == LoggerType.INFO) {
			System.out.println("INFO : " + message);
		}
		else {
			super.log(type, message);
		}
		
	}
	
}

class DebugCustomLogger extends CustomLogger{


	DebugCustomLogger(CustomLogger nextLogger) {
		super(nextLogger);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void log(LoggerType type, String message) {
		if(type == LoggerType.DEBUG) {
			System.out.println("DEBUG : " + message);
		}
		else {
			super.log(type, message);
		}
		
	}
	
}

class ErrorCustomLogger extends CustomLogger{

	ErrorCustomLogger(CustomLogger nextLogger) {
		super(nextLogger);

	}

	@Override
	public void log(LoggerType type, String message) {
		if(type == LoggerType.ERROR) {
			System.out.println("ERROR : " + message);
		}
		else {
			super.log(type, message);
		}
		
	}
	
}