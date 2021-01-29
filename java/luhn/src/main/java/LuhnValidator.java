import java.io.Console;
import java.util.stream.IntStream;

public class LuhnValidator {

    public boolean isValid(String candidate) {

        String input = candidate == null ? "" : candidate.trim().replace(" ", "");

        if (input.length() <= 1 || !input.matches("^[0-9]+$"))
            return false;

        int[] inputNumbers = new StringBuilder(input)
            .reverse()
            .chars()
            .map(Character::getNumericValue)
            .toArray();

        return IntStream
            .range(0, inputNumbers.length)
            .map(i -> (i + 1) % 2 == 0 ? doubleDigit(inputNumbers[i]) : inputNumbers[i])
            .sum() % 10 == 0;
    }

    private static int doubleDigit(int value) {
        int result = value * 2;
        return (result > 9) ? (result - 9) : result;
    }
}