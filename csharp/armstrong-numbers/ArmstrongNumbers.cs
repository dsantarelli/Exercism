using System;
using System.Linq;

public static class ArmstrongNumbers
{
  public static bool IsArmstrongNumber(int n)
  {
    var chars = n.ToString().AsEnumerable();
    var pow = chars.Count();
    return n == chars.Select(x => Math.Pow(double.Parse(x.ToString()), pow)).Sum();
  }
}