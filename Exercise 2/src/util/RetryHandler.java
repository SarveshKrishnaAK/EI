package src.util;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class RetryHandler {
    public static <T> T executeWithRetry(Supplier<T> action, int maxRetries, Logger logger) throws Exception {
        int attempts = 0;
        while (true) {
            try {
                return action.get();
            } catch (Exception e) {
                attempts++;
                logger.warning("Transient error: " + e.getMessage() + ", attempt " + attempts);
                if (attempts >= maxRetries) throw e;
                Thread.sleep(100 * attempts);
            }
        }
    }
}
