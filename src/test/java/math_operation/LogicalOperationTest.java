package math_operation;

import logging_system.logger.Logger;
import logging_system.logger.stdout_logger.StdoutLogger;
import logging_system.logger.stdout_logger.StdoutLoggerConfigurationLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicalOperationTest {
    String configPath = "src/main/java/logging_system/config/config.properties";
    Logger logger = new StdoutLogger(
            new StdoutLoggerConfigurationLoader().load(new File(configPath)));

    LogicalOperation logicalOperation;

    @BeforeEach
    void init() {
        logicalOperation = new LogicalOperation();
    }

    private static Stream<Arguments> numberContainsInArrayRandom() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 4, 1, 4}, 1, 4, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, 4, false),
                Arguments.of(new int[]{4, 4, 4, 4}, 1, 4, false),
                Arguments.of(new int[]{4, 1, 1, 1}, 1, 4, true)
        );
    }

    @ParameterizedTest
    @MethodSource("numberContainsInArrayRandom")
    void arrayContainsSearchingNumbersShouldTrue(int[] array, int firstNumber, int secondNumber, boolean isContains) {
        boolean expected = isContains;
        boolean actual = logicalOperation.isArrayContainsSearchingNumbers(array, firstNumber, secondNumber);
        assertEquals(expected, actual);
        logger.info(getClass().getSimpleName() + " - " + "Method: isArrayContainsSearchingNumbers - "
                    + Arrays.toString(array) + " " + firstNumber + " " + secondNumber +
                    " Expected: -> " + expected + "; Actual: ->" + actual);
    }
}