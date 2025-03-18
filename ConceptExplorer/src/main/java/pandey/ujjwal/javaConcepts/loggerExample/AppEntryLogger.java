package pandey.ujjwal.javaConcepts.loggerExample;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppEntryLogger {
	static Logger logger = Logger.getLogger("Evaluate_All_LLM");

	public static void main(String[] ar) throws IOException, URISyntaxException {
		logger = Logger.getLogger("Evaluate_All_LLM");
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("myapp.log");
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.setLevel(Level.INFO); // INFO, WARNING, SEVERE
		} catch (IOException e) {
			e.printStackTrace();
		}

		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);

		logger.warning("This is a warning message.");
		logger.severe("This is a severe error message.");
		
		
		// There are multiple methods availble for different work.
		
	}
}