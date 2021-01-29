import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {

  private final Map<Character, Integer> countersMap;

  public NucleotideCounter(String input) {

    countersMap = new HashMap<Character, Integer>();
    countersMap.put('A', 0);
    countersMap.put('C', 0);
    countersMap.put('G', 0);
    countersMap.put('T', 0);

    input
      .chars()
      .mapToObj(x -> Character.valueOf((char)x))
      .forEach(x -> countersMap.put(x, count(x) + 1));
  }

  public Map<Character, Integer> nucleotideCounts() {
    return countersMap;
  }

  public int count(Character nucleotide) {
    if (!countersMap.containsKey(nucleotide)) throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
    return countersMap.get(nucleotide);
  }
}