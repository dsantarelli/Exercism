import java.util.stream.IntStream;

public class PrimeCalculator {

  public int nth(int n) {
    if (n < 1) throw new IllegalArgumentException("n must be greater than 0");    
    int number = 1;
    int count = 0;
    while (count < n) {
      ++number;
      if (isPrime(number)) ++count;
    }
    return number;
  }

  private static boolean isPrime(int n) {
    return IntStream.rangeClosed(2, (int)Math.sqrt(n)).noneMatch(x -> n % x == 0);
  }
}