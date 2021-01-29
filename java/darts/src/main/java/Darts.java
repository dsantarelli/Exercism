import java.util.LinkedHashMap;
import java.util.Map;

class Darts {
  
  private static Map<Integer, Integer> scoresPerRadius = new LinkedHashMap<Integer, Integer>(){{
    put(1, 10);
    put(5, 5);
    put(10, 1);
  }};

  private final int score;

  Darts(double x, double y) {
    this.score = calculateScore(x, y);
  }

  int score() {
    return this.score;
  }

  private static int calculateScore(double x, double y) {
    double distanceFromCenter = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    for (Integer radius : scoresPerRadius.keySet()) {
      if (distanceFromCenter <= radius) {
        return scoresPerRadius.get(radius);
      }
    }
    return 0;
  }
}
