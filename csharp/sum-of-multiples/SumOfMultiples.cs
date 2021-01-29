using System.Linq;
using System.Collections.Generic;

public static class SumOfMultiples
{
  public static int Sum(IEnumerable<int> multiples, int max)
  {
    if (!multiples.Any()) return 0;
    var min = multiples.Min();
    if (max < min) return 0;
    return Enumerable
        .Range(min, max - min)
        .Where(f => multiples.Any(h => f % h == 0))
        .Sum();
  }
}