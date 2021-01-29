import java.util.stream.Collectors;

public class IsogramChecker {
  
  public boolean isIsogram(String input) {
    String string = input.toLowerCase().replaceAll("\\s+|\\p{Punct}", "");
    return string
      .chars()
      .boxed()
      .collect(Collectors.toSet())
      .size() == string.length();
  }
}