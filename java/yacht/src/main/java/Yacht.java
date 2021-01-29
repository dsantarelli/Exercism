import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Yacht {

    private static final Map<YachtCategory, Function<List<Integer>, Integer>> strategies = createStrategies();
    private static Map<YachtCategory, Function<List<Integer>, Integer>> createStrategies() {       
      Map<YachtCategory, Function<List<Integer>, Integer>> map = new HashMap<>();
      map.put(YachtCategory.ONES, x -> numberOf(1, x));
      map.put(YachtCategory.TWOS, x -> numberOf(2, x));
      map.put(YachtCategory.THREES, x -> numberOf(3, x));
      map.put(YachtCategory.FOURS, x -> numberOf(4, x));
      map.put(YachtCategory.FIVES, x -> numberOf(5, x));
      map.put(YachtCategory.SIXES, x -> numberOf(6, x));
      map.put(YachtCategory.FULL_HOUSE, x -> fullHouse(x));
      map.put(YachtCategory.FOUR_OF_A_KIND, x -> fourOfAKind(x));
      map.put(YachtCategory.LITTLE_STRAIGHT, x -> straight(x, 1));
      map.put(YachtCategory.BIG_STRAIGHT, x -> straight(x, 2));
      map.put(YachtCategory.CHOICE, x -> choice(x));
      map.put(YachtCategory.YACHT, x -> yacht(x));
      return map;      
    }
 
    private final Integer score;
  
    Yacht(int[] dice, YachtCategory yachtCategory) {
      this.score = strategies
        .get(yachtCategory)
        .apply(IntStream.of(dice).boxed().collect(Collectors.toList()));
    }

    int score() {
        return this.score;
    }
    
    private static Integer numberOf(int number, List<Integer> diceThrows) {
      return number * (int)diceThrows.stream().filter(x -> x.equals(number)).count();
    } 
    
    private static Integer fullHouse(List<Integer> diceThrows) {
      return diceThrows.stream().mapToInt(Integer::intValue).sum();
    } 
    
    private static Integer fourOfAKind(List<Integer> diceThrows) {      
      Map<Integer, List<Integer>> groups = diceThrows.stream().collect(Collectors.groupingBy(x -> x));
      
      return groups.size() <= 2 ? groups.values().stream().flatMap(x -> x.stream()).mapToInt(Integer::intValue).sum() : 0;
    }               
    
    private static Integer straight(List<Integer> diceThrows, int min) {                     
      List<Integer> distinctAndSorted = diceThrows.stream().distinct().sorted().collect(Collectors.toList());
      return distinctAndSorted.size() == diceThrows.size() && distinctAndSorted.get(0).equals(min) ? 30 : 0; 
   } 
    
    private static Integer choice(List<Integer> diceThrows) {                           
      return diceThrows.stream().mapToInt(Integer::intValue).sum();
   } 
    
    private static Integer yacht(List<Integer> diceThrows) {                           
      return ((int)diceThrows.stream().distinct().count()) == diceThrows.size() ? 50 : 0;
   } 
    
}
