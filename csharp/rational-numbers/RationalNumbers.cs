using System;

public static class RealNumberExtension
{
  public static double Expreal(this int realNumber, RationalNumber r)
  {
    return r.Expreal(realNumber);
  }
}

public struct RationalNumber
{
  public int Numerator { get; private set; }
  public int Denominator { get; private set; }

  public RationalNumber(int numerator, int denominator)
  {
    var mul = numerator * denominator;
    Numerator = Math.Abs(numerator) * (mul >= 0 ? 1 : -1);
    Denominator = Math.Abs(denominator);
  }

  public static RationalNumber operator +(RationalNumber r1, RationalNumber r2) { return r1.Add(r2); }
  public RationalNumber Add(RationalNumber r)
  {
    return new RationalNumber(Numerator * r.Denominator + r.Numerator * Denominator, Denominator * r.Denominator).Reduce();
  }

  public static RationalNumber operator -(RationalNumber r1, RationalNumber r2) { return r1.Sub(r2); }
  public RationalNumber Sub(RationalNumber r)
  {
    return new RationalNumber(Numerator * r.Denominator - r.Numerator * Denominator, Denominator * r.Denominator).Reduce();
  }

  public static RationalNumber operator *(RationalNumber r1, RationalNumber r2) { return r1.Mul(r2); }
  public RationalNumber Mul(RationalNumber r)
  {
    return new RationalNumber(Numerator * r.Numerator, Denominator * r.Denominator).Reduce();
  }

  public static RationalNumber operator /(RationalNumber r1, RationalNumber r2) { return r1.Div(r2); }
  public RationalNumber Div(RationalNumber r)
  {
    return new RationalNumber(Numerator * r.Denominator, Denominator * r.Numerator).Reduce();
  }

  public RationalNumber Abs()
  {
    return new RationalNumber(Math.Abs(Numerator), Math.Abs(Denominator));
  }

  public RationalNumber Reduce()
  {
    var gcd = Gcd(Numerator, Denominator);
    return new RationalNumber(Numerator / gcd, Denominator / gcd);
  }

  public RationalNumber Exprational(int power)
  {
    return power < 0 ?
      new RationalNumber((int)Math.Pow(Denominator, Math.Abs(power)), (int)Math.Pow(Numerator, Math.Abs(power))) :
      new RationalNumber((int)Math.Pow(Numerator, power), (int)Math.Pow(Denominator, power));
  }

  public double Expreal(int baseNumber)
  {
    return Math.Pow(baseNumber, (double)Numerator / Denominator);
  }

  private static int Gcd(int a, int b)
  {
    int n;
    while (b != 0)
    {
      n = a % b;
      a = b;
      b = n;
    }
    return a;
  }
}