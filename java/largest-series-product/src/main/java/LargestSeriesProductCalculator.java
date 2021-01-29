import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestSeriesProductCalculator {

  private final int[] digits;

  public LargestSeriesProductCalculator(String string) {

    if (string == null)
      throw new IllegalArgumentException("String to search must be non-null.");

    if (!string.isEmpty() && !string.matches("\\d+"))
      throw new IllegalArgumentException("String to search may only contains digits.");

    this.digits = string.chars().map(Character::getNumericValue).toArray();
  }

  public long calculateLargestProductForSeriesLength(int length) {

    if (length < 0)
      throw new IllegalArgumentException("Series length must be non-negative.");

    if (length > digits.length)
      throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

    return IntStream
        .rangeClosed(0, digits.length - length)
        .mapToLong(i -> 
            Arrays.stream(digits)
                  .skip(i)
                  .limit(length)
                  .asLongStream()
                  .reduce(1, (a, b) -> a * b))
        .max()
        .orElse(1);
  }
}