import java.util.HashMap;
import java.util.stream.IntStream;

class TwelveDays {

  private static HashMap<Integer, String[]> songMap = createSongMap();
  private static HashMap<Integer, String[]> createSongMap() {
    HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
    map.put(1, new String[] { "first", "a Partridge in a Pear Tree" });
    map.put(2, new String[] { "second", "two Turtle Doves" });
    map.put(3, new String[] { "third", "three French Hens" });
    map.put(4, new String[] { "fourth", "four Calling Birds" });
    map.put(5, new String[] { "fifth", "five Gold Rings" });
    map.put(6, new String[] { "sixth", "six Geese-a-Laying" });
    map.put(7, new String[] { "seventh", "seven Swans-a-Swimming" });
    map.put(8, new String[] { "eighth", "eight Maids-a-Milking" });
    map.put(9, new String[] { "ninth", "nine Ladies Dancing" });
    map.put(10, new String[] { "tenth", "ten Lords-a-Leaping" });
    map.put(11, new String[] { "eleventh", "eleven Pipers Piping" });
    map.put(12, new String[] { "twelfth", "twelve Drummers Drumming" });
    return map;
  }

  String verse(int verseNumber) {
    return String.format("On the %s day of Christmas my true love gave to me%s.\n", 
        songMap.get(verseNumber)[0],
        IntStream.rangeClosed(1, verseNumber)
          .map(i -> verseNumber - i + 1)
          .mapToObj(i -> (i == 1 && verseNumber > 1 ? "and " : "") + songMap.get(i)[1])
          .reduce("", (a, b) -> a + ", " + b));
  }

  String verses(int startVerse, int endVerse) {
    return IntStream.rangeClosed(startVerse, endVerse)
        .mapToObj(i -> verse(i) + (i < endVerse ? "\n" : ""))
        .reduce("", (a, b) -> a + b);
  }

  String sing() {
    return verses(1, 12);
  }
}
