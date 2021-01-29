import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {

  private static ArrayList<String[]> parts = createParts();
  private static ArrayList<String[]> createParts() {
    ArrayList<String[]> map = new ArrayList<>();
    map.add(new String[] { "lay in", "house that Jack built" });
    map.add(new String[] { "ate", "malt" });
    map.add(new String[] { "killed", "rat" });
    map.add(new String[] { "worried", "cat" });
    map.add(new String[] { "tossed", "dog" });
    map.add(new String[] { "milked", "cow with the crumpled horn" });
    map.add(new String[] { "kissed", "maiden all forlorn" });
    map.add(new String[] { "married", "man all tattered and torn" });
    map.add(new String[] { "woke", "priest all shaven and shorn" });
    map.add(new String[] { "kept", "rooster that crowed in the morn" });
    map.add(new String[] { "belonged to", "farmer sowing his corn" });
    map.add(new String[] { "", "horse and the hound and the horn" });
    return map;
  }

  public String verse(int verse) {
    return buildRhyme(1, verse);
  }

  public String sing() {
    return verses(1, 12);
  }

  public String verses(int startVerse, int endVerse) {
    return IntStream
        .rangeClosed(startVerse, endVerse)
        .mapToObj(x -> buildRhyme(1, x))
        .collect(Collectors.joining("\n\n"));
  }

  private static String buildRhyme(int startVerse, int endVerse) {
    String output = "This is the " + parts.get(endVerse - 1)[1];

    for (int i = endVerse - 2; i > startVerse - 2; i--)
      output += "\nthat " + parts.get(i)[0] + " the " + parts.get(i)[1];

    return output + ".";
  }
}