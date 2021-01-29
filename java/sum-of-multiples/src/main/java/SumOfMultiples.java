import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfMultiples {

  private final int sum;

  SumOfMultiples(int number, int[] set) {
    sum = IntStream
            .range(1, number)
            .filter(x -> isMultipleOfAny(x, set))
            .sum();
  }

  public int getSum() {
    return sum;
  }

  private static boolean isMultipleOfAny(int number, int[] set){
    return Arrays.stream(set).anyMatch(x -> number % x == 0);
  }
  
}
