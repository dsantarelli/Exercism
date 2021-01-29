using System.Collections.Generic;
using System.Linq;

public class HighScores
{
  private readonly List<int> _list;

  public HighScores(List<int> list) => _list = list;

  public List<int> Scores() => _list;

  public int Latest() => _list.Last();

  public int PersonalBest() => _list.Max();

  public List<int> PersonalTop() => _list.OrderByDescending(x => x).Take(3).ToList();

  public string Report()
  {
    var latest = Latest();
    var best = PersonalBest();

    return latest == best ?
      $"Your latest score was {latest}. That's your personal best!" :
      $"Your latest score was {latest}. That's {best - latest} short of your personal best!";
  }
}