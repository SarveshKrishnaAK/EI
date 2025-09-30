package src.util;

import java.io.IOException;
import java.util.logging.*;

public class LoggerFactory {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger("VirtualClassroomManager");
            try {
                Handler fileHandler = new FileHandler("vcm.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                logger.warning("Failed to initialize file handler for logging.");
            }
            logger.setUseParentHandlers(true);
        }
        return logger;
    }
}
