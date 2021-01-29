using System.Linq;

public static class Pangram
{
  public static bool IsPangram(string input)
  {    
    var lower = input.ToLowerInvariant();
    return Enumerable
      .Range('a', 'z' - 'a')
      .All(x => lower.IndexOf((char)x) >= 0);
  }
}