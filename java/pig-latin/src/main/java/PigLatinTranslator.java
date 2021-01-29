import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinTranslator {

 private static final Pattern VOWELS_PATTERN = Pattern.compile("((?<!q)[aeiou])|([xy](?![aeiou]))");

 public static String translate(String phrase) {
    return Arrays
      .stream(phrase.trim().toLowerCase().split(" "))
      .map(PigLatinTranslator::translateWord)
      .collect(Collectors.joining(" "));
  }

  private static String translateWord(String word) {
    Matcher matcher = VOWELS_PATTERN.matcher(word);
    int vowelIndex = matcher.find() ? matcher.start() : 0;
    return word.substring(vowelIndex) + word.substring(0, vowelIndex) + "ay";
  }  
}