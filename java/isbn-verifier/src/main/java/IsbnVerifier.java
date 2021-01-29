import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsbnVerifier {

    private static final int CHECK_NUMBER = 10;
    private static final String CHECK_CHAR = "X";
    private static final int CHECK_SUM = 11;
  
    boolean isValid(String stringToVerify) {
                      
        List<Integer> numbers = stringToVerify            
            .chars()
            .filter(c -> Character.isDigit(c) || isCheckChar((char)c))
            .mapToObj(c -> isCheckChar((char)c) ? CHECK_NUMBER : Character.getNumericValue((char)c))
            .collect(Collectors.toList());
        
        if (numbers.size() != CHECK_NUMBER) 
          return false;
        
        int checkNumberIndex = numbers.indexOf(CHECK_NUMBER);
        if (checkNumberIndex >= 0 && checkNumberIndex < CHECK_NUMBER - 1)
          return false;
        
        return IntStream
            .range(0, numbers.size())
            .map(i -> numbers.get(i) * (numbers.size() - i))
            .reduce(0, (a, b) -> a + b) % CHECK_SUM == 0;
    }
    
    private static boolean isCheckChar(char c) {
      return String.valueOf(c).equals(CHECK_CHAR);
    }
}