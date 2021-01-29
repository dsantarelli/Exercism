import java.util.stream.IntStream;

class Proverb {
    
  private final String[] words;

  Proverb(String[] words) {
    this.words = words;   
  }

  String recite() {
    return (words.length == 0) ? "" : 
      IntStream
        .range(0, words.length - 1)
        .mapToObj(i -> "For want of a " + words[i] + " the " + words[i + 1] + " was lost.")
        .reduce("", (a,b) -> a + b + "\n")
        .concat("And all for the want of a " + words[0] + ".");
  }
}