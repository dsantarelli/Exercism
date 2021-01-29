import java.util.Arrays;

class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase == null ? "" : phrase.trim();
    }

    String get() {        
        return Arrays
            .stream(phrase.split("\\s+|\\p{Punct}"))
            .filter(x -> x.length() > 0)
            .map(x -> String.valueOf(x.charAt(0)))
            .reduce("", (a, b) -> a + b)
            .toUpperCase();
    }
}