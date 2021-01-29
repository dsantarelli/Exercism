using System.Linq;
using System.Collections.Generic;

public static class Etl
{
  public static Dictionary<string, int> Transform(Dictionary<int, string[]> old)
  {    
    return old
      .SelectMany(x => x.Value)      
      .ToDictionary(
        letter => letter.ToLowerInvariant(), 
        letter => old.First(x => x.Value.Contains(letter)).Key);    
  }
}