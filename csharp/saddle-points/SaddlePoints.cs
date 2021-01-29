using System.Collections.Generic;

public class SaddlePoints
{
  private readonly int[,] _values;

  public SaddlePoints(int[,] values) => _values = values;

  public IEnumerable<(int, int)> Calculate()
  {
    for (int x = 0; x < _values.GetLength(0); x++)
      for (int y = 0; y < _values.GetLength(1); y++)
        if (IsSaddlePoint(x, y))
          yield return (x, y);
  }

  private bool IsSaddlePoint(int x, int y)
  {
    int value = _values[x, y];

    for (int i = 0; i < _values.GetLength(0); i++)
      if (value > _values[i, y]) return false;

    for (int j = 0; j < _values.GetLength(1); j++)
      if (value < _values[x, j]) return false;

    return true;
  }
}