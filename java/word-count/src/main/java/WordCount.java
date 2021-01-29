import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
  
  public Map<String, Integer> phrase(String string) {
    
    Map<String, Integer> wordCount = new HashMap<String, Integer>();
    
    Arrays
      .stream(string.toLowerCase().split("\\s+"))
      .map(x -> x.replaceAll("\\W", ""))
      .filter(x -> !x.isEmpty())
      .forEach(x -> wordCount.put(x, wordCount.getOrDefault(x, 0) + 1));
    
    return wordCount;
  }
}