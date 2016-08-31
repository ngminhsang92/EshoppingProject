package eshopping.aop;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("EStoreLogger").info(logstring);		
	}
}
