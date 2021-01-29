using System.Collections.Generic;
using System.Linq;

public static class RnaTranscription
{
  private static readonly Dictionary<char, char> RNA_MAP = new Dictionary<char, char>()
  {
    { 'C', 'G' },
    { 'G', 'C' },
    { 'T', 'A' },
    { 'A', 'U' }
  };

  public static string ToRna(string dnaStrand)
  {
    return new string(dnaStrand
      .Where(x => RNA_MAP.ContainsKey(x))
      .Select(x => RNA_MAP[x])
      .ToArray());
  }
}