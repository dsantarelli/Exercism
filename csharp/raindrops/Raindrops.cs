using System;
using System.Linq;
using System.Collections.Generic;

public static class Raindrops
{
  private static Dictionary<int, string> outputs = new Dictionary<int, string>()
  {
      {3, "Pling"},
      {5, "Plang"},
      {7, "Plong"}
  };

  public static string Convert(int number)
  {
    return String.Join("", outputs.Keys
      .Where(factor => (number % factor) == 0)
      .Select(factor => outputs[factor])
      .DefaultIfEmpty(number.ToString()));
  }
}