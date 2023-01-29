package logging_system.logger;

import java.io.File;

public abstract class LoggerConfigurationLoader {
    public abstract LoggerConfiguration load(File configFile);
}