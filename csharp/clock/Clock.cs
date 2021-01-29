public class Clock
{  
  private const int MINUTES_IN_A_HOUR = 60;
  private const int MINUTES_IN_A_DAY = 24 * MINUTES_IN_A_HOUR;

  private readonly int _time;
  
  public int Hours { get; }  
  public int Minutes { get; }

  public Clock(int hours, int minutes = 0)
  {
    _time = (MINUTES_IN_A_HOUR * hours + minutes) % (MINUTES_IN_A_DAY);
    while (_time < 0) _time += MINUTES_IN_A_DAY;
    Hours = _time / MINUTES_IN_A_HOUR;
    Minutes = _time % MINUTES_IN_A_HOUR;
  }

  public Clock Add(int minutes) => new Clock(0, _time + minutes);

  public Clock Subtract(int minutes) => Add(-minutes);

  public override string ToString() => string.Format("{0:00}:{1:00}", Hours, Minutes);

  public override bool Equals(object obj) => obj is Clock clock && _time == clock._time;

  public override int GetHashCode() => 155545983 + _time.GetHashCode();
}