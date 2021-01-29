import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {

  private static final Map<String, Integer> colors = buildColorsMap();
  private static Map<String, Integer> buildColorsMap() {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("black", 0);
    map.put("brown", 1);
    map.put("red", 2);
    map.put("orange", 3);
    map.put("yellow", 4);
    map.put("green", 5);
    map.put("blue", 6);
    map.put("violet", 7);
    map.put("grey", 8);
    map.put("white", 9);
    return map;
  }

  int colorCode(String color) { 
    return colors.get(color.toLowerCase());
  }

  String[] colors() {
    return colors.keySet().toArray(new String[colors.size()]);
  }
}
