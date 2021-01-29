import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunLengthEncoding {

  public String encode(String string) {
    if (string.isEmpty()) return "";
    StringBuilder builder = new StringBuilder();
    int count = 1;
    char[] chars = string.toCharArray();
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == chars[i - 1]) ++count;
      else {
        builder.append(buildEncodedCharString(chars[i - 1], count));
        count = 1;
      }
    }
    builder.append(buildEncodedCharString(chars[chars.length - 1], count));
    return builder.toString();
  }

  public String decode(String string) {
    StringBuilder builder = new StringBuilder();
    char[] chars = string.toCharArray();
    int lastLetterIndex = -1;
    int letterCount = 0;
    for (int i = 0; i < chars.length; i++) {
      if (!Character.isDigit(chars[i])) {
        letterCount = (i == lastLetterIndex + 1) ? 1 : Integer.parseInt(string.substring(lastLetterIndex + 1, i));
        builder.append(buildDecodedCharString(chars[i], letterCount));
        lastLetterIndex = i;
      }
    }
    return builder.toString();
  }

  private static String buildEncodedCharString(char ch, int count) {
    return count == 1 ? String.valueOf(ch) : ("" + count + ch);
  }

  private static String buildDecodedCharString(char ch, int count) {
    return count == 1 ? String.valueOf(ch) : IntStream.range(0, count).mapToObj(x -> String.valueOf(ch)).collect(Collectors.joining());
  }
}