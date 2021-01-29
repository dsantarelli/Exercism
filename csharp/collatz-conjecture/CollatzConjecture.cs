using System;

public static class CollatzConjecture
{
  public static int Steps(int number)
  {
    if (number <= 0) throw new ArgumentException("Please specify a positive integer.");
    int steps = 0;
    int n = number;
    while (n > 1) {
      n = (n % 2 == 0) ? (n / 2) : (n * 3 + 1);
      ++steps;
    }            
    return steps;
  }
}