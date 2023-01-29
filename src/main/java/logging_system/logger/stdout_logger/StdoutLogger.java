package logging_system.logger.stdout_logger;

import logging_system.logger.Logger;
import logging_system.logger.LoggingLevel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StdoutLogger extends Logger {
    StdoutLoggerConfiguration loggerConfiguration;

    public StdoutLogger(StdoutLoggerConfiguration loggerConfiguration) {
        this.loggerConfiguration = loggerConfiguration;
    }

    @Override
    public void info(String message) {
        System.out.println(messageTemplate(message));
    }

    @Override
    public void debug(String message) {
        if (!loggerConfiguration.getLogginLevel().equals(LoggingLevel.INFO)) {
            System.out.println(messageTemplate(message));
        }
    }

    private String messageTemplate(String message) {
        return String.format(
                loggerConfiguration.getFormatWritting(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")),
                loggerConfiguration.getLogginLevel(),
                "Message ",
                message);
    }
}
