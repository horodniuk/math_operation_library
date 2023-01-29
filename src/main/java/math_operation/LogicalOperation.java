package math_operation;

import java.util.Arrays;

public class LogicalOperation {
    public boolean isArrayContainsSearchingNumbers(int[] array, int a, int b) {
        return Arrays.stream(array).anyMatch(x -> x == a) && Arrays.stream(array).anyMatch(x -> x == b);
    }
}
