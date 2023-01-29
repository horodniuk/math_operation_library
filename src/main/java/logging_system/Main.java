package logging_system;


import logging_system.logger.AbstractLogger;
import logging_system.logger.file_logger.FileLogger;
import logging_system.logger.file_logger.FileLoggerConfiguration;
import logging_system.logger.file_logger.FileLoggerConfigurationLoader;
import logging_system.logger.stdout_logger.StdoutLogger;
import logging_system.logger.stdout_logger.StdoutLoggerConfiguration;
import logging_system.logger.stdout_logger.StdoutLoggerConfigurationLoader;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String configPath = "src/main/java/logging_system/config/config.properties";

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfigurationLoader().load(new File(configPath));
        StdoutLoggerConfiguration stdoutLoggerConfiguration = new StdoutLoggerConfigurationLoader().load(new File(configPath));

        AbstractLogger logger = new StdoutLogger(stdoutLoggerConfiguration);

        logger.info("test-1 log-info");
        logger.debug("test-2 log-debug");


        logger = new FileLogger(fileLoggerConfiguration);

        logger.info("test-5 log-info");
        logger.debug("test-6 log-debug");
        logger.info("test-7 log-info");
        logger.debug("test-8 log-debug");
    }
}
