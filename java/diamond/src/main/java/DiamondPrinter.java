import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiamondPrinter {

  private static final int A = 'A';

  public List<String> printToList(char input) {    

    int sideLength = (input - A) * 2 + 1;

    List<String> topHalf = IntStream
      .rangeClosed(A, input)
      .mapToObj(ch -> buildRowString(ch, sideLength))
      .collect(Collectors.toList());
          
    List<String> bottomHalf = IntStream
      .range(0, topHalf.size() - 1)
      .map(i -> topHalf.size() - i - 2)
      .mapToObj(i -> topHalf.get(i))
      .collect(Collectors.toList());
        
    return Stream
      .concat(topHalf.stream(), bottomHalf.stream())
      .collect(Collectors.toList());
  }

  private static String buildRowString(int ch, int length) {    
    int offset = ch - A;
    int middle = length / 2;
    int left = middle - offset;
    int right = middle + offset;
    return IntStream
      .range(0, length)
      .mapToObj(i -> (left == i || right == i) ? String.valueOf((char)ch) : " ")
      .reduce("", (a, b) -> a + b);
  }
}