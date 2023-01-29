package logging_system.logger;

public abstract class LoggerConfiguration {
    private final LoggingLevel logginLevel;
    private final String formatWritting;

    public LoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        this.logginLevel = logginLevel;
        this.formatWritting = formatWritting;
    }

    public LoggingLevel getLogginLevel() {
        return logginLevel;
    }

    public String getFormatWritting() {
        return formatWritting;
    }
}
