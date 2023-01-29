package logging_system.logger.stdout_logger;

import logging_system.logger.AbstractLoggerConfiguration;
import logging_system.logger.LoggingLevel;

public class StdoutLoggerConfiguration extends AbstractLoggerConfiguration {
    public StdoutLoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        super(logginLevel, formatWritting);
    }
}
