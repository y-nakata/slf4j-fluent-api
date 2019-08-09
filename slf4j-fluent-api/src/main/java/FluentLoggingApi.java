import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluentLoggingApi {

	private int t16() {
		return 16;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(FluentLoggingApi.class);
	
	public static void main(String[] args) {
		FluentLoggingApi app = new FluentLoggingApi();
		app.fluentLoggingExample();
		app.fluentKeyValueLoggingExample();
	}

	private void fluentLoggingExample() {
		int newT = 15;
		int oldT = 16;
		
		// using traditional API
		logger.debug("Temperature set to {}. Old temperature was {}.", newT, oldT);
		
		// using fluent API, add arguments one by one and then log message
		logger.atDebug().addArgument(newT).addArgument(oldT).log("Temperature set to {}. Old temperature was {}.");
		
		// using fluent API, log message with arguments
		logger.atDebug().log("Temperature set to {}. Old temperature was {}.", newT, oldT);
		
		// using fluent API, add one argument and then log message providing one more argument
		logger.atDebug().addArgument(newT).log("Temperature set to {}. Old temperature was {}.", oldT);
		
		// using fluent API, add one argument with a Supplier and then log message with one more argument.
		// Assume the method t16() returns 16.
		logger.atDebug().addArgument(() -> t16()).log("Temperature set to {}. Old temperature was {}.", oldT);
	}
	
	private void fluentKeyValueLoggingExample() {
		int newT = 15;
		int oldT = 16;
		
		// using classical API
		logger.debug("oldT={} newT={} Temperature changed.", oldT, newT);
		
		// using fluent API
		logger.atDebug().addKeyValue("oldT", oldT).addKeyValue("newT", newT).log("Temperature changed.");
	}

}
