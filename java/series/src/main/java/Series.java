import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Series {

  private final List<Integer> digits;

  public Series(String input) {
    digits = Collections.unmodifiableList(input
        .chars()
        .map(Character::getNumericValue)
        .boxed()
        .collect(Collectors.toList()));
  }

  public List<Integer> getDigits() {
    return digits;
  }

  public List<List<Integer>> slices(int n) {
    if (n > digits.size()) throw new IllegalArgumentException();
    return IntStream
        .range(0, digits.size() - n + 1)
        .mapToObj(i -> digits.stream().skip(i).limit(n).collect(Collectors.toList()))
        .collect(Collectors.toList());
  }
}