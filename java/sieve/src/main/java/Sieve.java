import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

  private final List<Integer> primes;

  Sieve(int maxPrime) {
    primes = Collections.unmodifiableList(
        IntStream.rangeClosed(2, maxPrime)
        .filter(n -> IntStream.range(2, n).noneMatch(i -> n % i == 0))
        .boxed()
        .collect(Collectors.toList()));
  }

  List<Integer> getPrimes() {
    return primes;
  }
}