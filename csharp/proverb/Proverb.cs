using System.Linq;

public static class Proverb
{
  public static string[] Recite(string[] words) => 
    !words.Any() ? new string[0] :
    Enumerable.Concat
    (
       Enumerable
        .Range(0, words.Length - 1)
        .Select(i => $"For want of a {words[i]} the {words[i + 1]} was lost."),

       new[] { $"And all for the want of a {words[0]}." }
    )
    .ToArray();
}