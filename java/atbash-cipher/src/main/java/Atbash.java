import java.util.stream.Collectors;

public class Atbash {

  public String encode(String plaintext) {
    String input = plaintext.replaceAll("\\p{Punct}|\\s+", "").toLowerCase();
    String output = "";
    for (int i = 0; i < input.length(); i++) {
      if (i > 0 && i % 5 == 0) output += " ";
      output += encodeChar(input.charAt(i));
    }
    return output;
  }

  public String decode(String ciphertext) {
    return ciphertext        
        .replaceAll("\\s+", "")
        .chars()
        .mapToObj(x -> String.valueOf(decodeChar((char)x)))
        .collect(Collectors.joining());
  }

  private static char encodeChar(char ch) {
    if (!Character.isLetter(ch)) return ch;    
    return (char)('z' - (int)(ch - 'a'));
  }

  private static char decodeChar(char ch) {
    if (!Character.isLetter(ch)) return ch;
    return (char)('a' + (int)('z' - ch));
  }
}