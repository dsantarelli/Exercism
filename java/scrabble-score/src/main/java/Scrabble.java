import java.util.Arrays;
import java.util.HashMap;

class Scrabble {

    private final String word;
    private static final HashMap<Character, Integer> scoreMap = createScoreMap();
    private static HashMap<Character, Integer> createScoreMap() {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Arrays.stream(new Character[] { 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' }).forEach(c -> map.put(c, 1));
        Arrays.stream(new Character[] { 'D', 'G' }).forEach(c -> map.put(c, 2));
        Arrays.stream(new Character[] { 'B', 'C', 'M', 'P' }).forEach(c -> map.put(c, 3));
        Arrays.stream(new Character[] { 'F', 'H', 'V', 'W', 'Y' }).forEach(c -> map.put(c, 4));
        Arrays.stream(new Character[] { 'K' }).forEach(c -> map.put(c, 5));
        Arrays.stream(new Character[] { 'J', 'X' }).forEach(c -> map.put(c, 8));
        Arrays.stream(new Character[] { 'Q', 'Z' }).forEach(c -> map.put(c, 10));
        return map;
    }

    Scrabble(String word) {
        this.word = word == null ? "" : word.trim().toUpperCase();
    }

    int getScore() {
        return word
            .chars()
            .map(c -> scoreMap.getOrDefault((char) c, 0))
            .reduce(0, (a, b) -> a + b);
    }
}