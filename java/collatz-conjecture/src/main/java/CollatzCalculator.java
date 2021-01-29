public class CollatzCalculator {
  public int computeStepCount(int number) {
    if (number <= 0) throw new IllegalArgumentException("Only natural numbers are allowed");
    int steps = 0; 
    int n = number;
    while (n > 1) {
      n = (n % 2 == 0) ? (n / 2) : (3 * n + 1);
      ++steps;
    }
    return steps;
  }
}