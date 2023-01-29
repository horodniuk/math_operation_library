package logging_system.logger;

import java.io.File;

public abstract class AbstractLoggerConfigurationLoader {
    public abstract AbstractLoggerConfiguration load(File configFile);
}