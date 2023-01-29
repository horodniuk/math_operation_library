package logging_system.logger.file_logger;

import logging_system.logger.AbstractLoggerConfiguration;
import logging_system.logger.LoggingLevel;

public class FileLoggerConfiguration extends AbstractLoggerConfiguration {
    private final String pathFileLogger;
    private final long maxSize;

    public FileLoggerConfiguration(LoggingLevel logginLevel, String formatWritting, String pathFileLogger, long maxSize) {
        super(logginLevel, formatWritting);
        this.pathFileLogger = pathFileLogger;
        this.maxSize = maxSize;
    }

    public String getPathFileLogger() {
        return pathFileLogger;
    }

    public long getMaxSize() {
        return maxSize;
    }
}
