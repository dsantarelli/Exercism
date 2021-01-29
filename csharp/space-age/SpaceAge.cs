public class SpaceAge
{
  private readonly double _seconds;

  public SpaceAge(double seconds) => _seconds = seconds;

  public double OnEarth() => GetAge(1.0);
  public double OnMercury() => GetAge(0.2408467);
  public double OnVenus() => GetAge(0.61519726);
  public double OnMars() => GetAge(1.8808158);
  public double OnJupiter() => GetAge(11.862615);
  public double OnSaturn() => GetAge(29.447498);
  public double OnUranus() => GetAge(84.016846);
  public double OnNeptune() => GetAge(164.79132);

  private double GetAge(double factor) => _seconds / (31557600 * factor);
}