using System;
using System.Linq;

public static class Hamming
{
  public static int Distance(string firstStrand, string secondStrand)
  {
    if (firstStrand.Length != secondStrand.Length)
      throw new ArgumentException("firstStrand and secondStrand must be of equal length.");

    return firstStrand.Where((x, i) => x != secondStrand[i]).Count();
  }
}