import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
  
  public List<Long> calculatePrimeFactorsOf(Long number) {
    
    Long divisor = 2L;
    Long leaving = number;
    List<Long> primeFactors = new ArrayList<>();
    
    while (leaving > 1) {    
      while (leaving % divisor == 0) {
        leaving = leaving / divisor;
        primeFactors.add(divisor);
      }
      ++divisor;
    }
    return primeFactors;   
  }
}