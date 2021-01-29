using System;
using System.Linq;
using System.Collections.Generic;

public class NucleotideCount
{
  private static IDictionary<char, int> BuildDictionary() => new Dictionary<char, int>
  {
    { 'A', 0 },
    { 'C', 0 },
    { 'G', 0 },
    { 'T', 0 }
  };

  public IDictionary<char, int> NucleotideCounts { get; private set; }

  public NucleotideCount(string sequence)
  {    
    NucleotideCounts = BuildDictionary();
    
    foreach (var key in NucleotideCounts.Keys.ToArray())    
      NucleotideCounts[key] = sequence.Count(x => x == key);

    if (sequence.Length != NucleotideCounts.Values.Sum())
      throw new ArgumentException("Strand with invalid nucleotides: " + sequence);
  }
}