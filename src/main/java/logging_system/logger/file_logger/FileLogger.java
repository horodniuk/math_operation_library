package logging_system.logger.file_logger;


import logging_system.logger.Logger;
import logging_system.logger.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger extends Logger {
    private final FileLoggerConfiguration fileLoggerConfiguration;
    private String currentPath;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
        currentPath = fileLoggerConfiguration.getPathFileLogger() + String.format("Log_%s.txt", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")));
    }

    @Override
    public void debug(String message) {
        if (!fileLoggerConfiguration.getLogginLevel().equals(LoggingLevel.INFO)) {
            checkSizeCurrentFile(message);
            writeLog(message);
        }
    }

    @Override
    public void info(String message) {
        checkSizeCurrentFile(message);
        writeLog(message);
    }

    private void checkSizeCurrentFile(String message) {
        long currentFileSize = new File(currentPath).length();
        int messageSize = message.getBytes().length;
        if (currentFileSize + messageSize >= fileLoggerConfiguration.getMaxSize()) {
            currentPath = createNewFilePath();
        }
    }

    private void writeLog(String message) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(currentPath, true))) {
            output.write(messageTemplate(message));
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String messageTemplate(String message) {
        return String.format(
                fileLoggerConfiguration.getFormatWritting(),
                "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")) + "]",
                "[" + fileLoggerConfiguration.getLogginLevel() + "]",
                "Message",
                "[" + message + "]"
        );
    }

    private String createNewFilePath() {
        return String.format("src/main/java/logging_system/logs/Log_%s.txt",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS")));
    }
}
