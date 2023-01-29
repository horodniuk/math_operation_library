package logging_system.logger.stdout_logger;

import logging_system.logger.LoggerConfiguration;
import logging_system.logger.LoggingLevel;

public class StdoutLoggerConfiguration extends LoggerConfiguration {
    public StdoutLoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        super(logginLevel, formatWritting);
    }
}
