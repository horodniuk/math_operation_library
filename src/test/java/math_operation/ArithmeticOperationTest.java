package math_operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArithmeticOperationTest {
    ArithmeticOperation arithmeticOperation;

    @BeforeEach
    void init() {
        arithmeticOperation = new ArithmeticOperation();
    }

    private static Stream<Arguments> trueSum() {
        return Stream.of(
                arguments(1, 2, 3.0),
                arguments(2, 1, 3.0),
                arguments(0, 4, 4.0),
                arguments(4, 0, 4.0),
                arguments(0, -4, -4.0),
                arguments(-2, 4, 2.0),
                arguments(-4, 2, -2.0),
                arguments(-4, 0, -4.0),
                arguments(-2, -1, -3.0)
        );
    }

    @ParameterizedTest
    @MethodSource("trueSum")
    void sumNumbersConvertShouldTrue(int a, int b, double resultOperation) {
        double expected = resultOperation;
        double actual = arithmeticOperation.add(a, b);
    }

    private static Stream<Arguments> minusSum() {
        return Stream.of(
                arguments(3, 2, 1.0),
                arguments(3, 1, 2.0),
                arguments(-4, -4, 0.0),
                arguments(1, -3, 4.0),
                arguments(0, -1, 1.0),
                arguments(1, 3, -2.0),
                arguments(-2, 3, -5.0),
                arguments(-3, 1, -4.0),
                arguments(-3, 0, -3.0)
        );
    }

    @ParameterizedTest
    @MethodSource("minusSum")
    void minusNumbersConvertShouldTrue(int a, int b, double resultOperation) {
        double expected = resultOperation;
        double actual = arithmeticOperation.minus(a, b);
    }
}