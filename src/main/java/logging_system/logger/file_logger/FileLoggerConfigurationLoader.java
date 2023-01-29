package logging_system.logger.file_logger;

import logging_system.logger.AbstractLoggerConfigurationLoader;
import logging_system.logger.LoggingLevel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader {
    @Override
    public FileLoggerConfiguration load(File configFile) {
        try (FileReader reader = new FileReader(configFile)) {
            Properties p = new Properties();
            p.load(reader);
            return new FileLoggerConfiguration(
                    LoggingLevel.valueOf(p.getProperty("LEVEL")),
                    p.getProperty("FORMAT"),
                    p.getProperty("FILE_PATH"),
                    Long.parseLong((p.getProperty("MAX-SIZE"))));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
