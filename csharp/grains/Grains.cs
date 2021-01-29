using System;
using System.Linq;

public static class Grains
{
  private const int MAX_SQUARE = 64;

  public static ulong Square(int n)
  {
    if (n < 1 || n > MAX_SQUARE) throw new ArgumentOutOfRangeException($"Square size must greater than zero and less than {MAX_SQUARE}");
    return 1UL << (n - 1);
  }

  public static ulong Total() =>
    (ulong)Enumerable.Range(1, MAX_SQUARE)
    .Select(i => (long)Square(i))
    .Sum();
}