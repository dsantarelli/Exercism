using System;

public class Robot
{
  private static readonly Random random = new Random();

  public string Name { get; private set; }

  public Robot()
    => Reset();

  public void Reset()
    => Name = GenerateName();

  private static string GenerateName()
    =>
    RandomLetter() +
    RandomLetter() +
    RandomNumber() +
    RandomNumber() +
    RandomNumber();

  private static string RandomLetter()
    => ((char)(random.Next(26) + 'A')).ToString();

  private static string RandomNumber()
    => random.Next(9).ToString();
}