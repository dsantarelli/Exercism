using System.Linq;
using System.Text.RegularExpressions;

public static class Acronym
{
  public static string Abbreviate(string phrase) =>
      Regex.Split(phrase, @"[^\w]+")
      .Select(x => x[0].ToString().ToUpperInvariant())
      .Aggregate("", (a, b) => a + b);
}