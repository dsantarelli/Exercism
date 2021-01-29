public class RotationalCipher {

  private final int A = (int) 'A';
  private final int Z = (int) 'Z';
  private final int a = (int) 'a';
  private final int z = (int) 'z';
  private final int key;

  public RotationalCipher(int key) {
    this.key = key;
  }

  public String rotate(String string) {
    return string.chars()
        .map(this::rotateChar)
        .mapToObj(c -> Character.toString((char)c))
        .reduce("", (a, b) -> a + b);
  }

  private int rotateChar(int c) {
    int shift = c + key;
    return (c >= a && c <= z) ? shift <= z ? shift : (a + shift - z - 1) : 
           (c >= A && c <= Z) ? shift <= Z ? shift : (A + shift - Z - 1) : 
            c;
  }
}