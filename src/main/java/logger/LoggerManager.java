package logger;

public class LoggerManager {

    static Logger logger;
    static LoggerManager loggerManager;

    private LoggerManager(Logger logger) {
        this.logger = logger;
    }

    public static LoggerManager createInstanceUpdatedLogger(Logger logger) {
        if(loggerManager == null) {
            loggerManager = new LoggerManager(logger);
        }
        else {
            LoggerManager.logger = logger;
        }
        return loggerManager;
    }

    public LoggerManager updateLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public static LoggerManager getInstance() {
        if(loggerManager == null) {
            throw new IllegalStateException("Un-initialized static class. \nPlease use 'createInstance(Logger)' first.");
        }
        return loggerManager;
    }
    public void log(String message) {
        logger.log(message);
    }

    public void fail(String message) {
        logger.fail(message);
    }
}
