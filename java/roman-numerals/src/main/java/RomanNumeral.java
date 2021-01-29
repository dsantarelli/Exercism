import java.util.TreeMap;

public class RomanNumeral {

  private static final TreeMap<Integer, String> map = createNumeralMap();
  private static TreeMap<Integer, String> createNumeralMap() {
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
    return map;
  }

  private final String romanNumeral;

  public RomanNumeral(int number) {
    romanNumeral = number > 0 ? convertToRomanNumeral(number) : "";
  }

  public String getRomanNumeral() {
    return romanNumeral;
  }

  private static String convertToRomanNumeral(int number) {
    int key = map.floorKey(number);
    return (number == key) ? map.get(number) : map.get(key) + convertToRomanNumeral(number - key);
  }
}