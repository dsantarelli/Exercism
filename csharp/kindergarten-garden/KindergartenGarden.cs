using System;
using System.Linq;
using System.Collections.Generic;

public class KindergartenGarden
{
  private const int WINDOW_SIZE = 2;
  private static readonly string[] DEFAULT_STUDENTS = { "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry" };
  private static readonly Dictionary<char, Plant> PLANT_MAPPING = new Dictionary<char, Plant>
  {
    { 'V', Plant.Violets },
    { 'R', Plant.Radishes },
    { 'C', Plant.Clover },
    { 'G', Plant.Grass }
  };

  private readonly Dictionary<string, List<Plant>> _plantsPerStudent;

  public KindergartenGarden(string diagram) : this(diagram, DEFAULT_STUDENTS) { }
  public KindergartenGarden(string diagram, IEnumerable<string> students)
  {
    _plantsPerStudent = students.ToDictionary(x => x, x => new List<Plant>());
    var rows = diagram.Split(new[] { "\n" }, StringSplitOptions.RemoveEmptyEntries);
    foreach (var row in rows)
    {
      var offset = 0;
      foreach (var student in _plantsPerStudent.Keys)
      {
        _plantsPerStudent[student].AddRange(row.Skip(offset).Take(WINDOW_SIZE).Select(x => PLANT_MAPPING[x]));
        offset += WINDOW_SIZE;
      }
    }
  }

  public IEnumerable<Plant> Plants(string student)
  {
    return _plantsPerStudent[student].AsReadOnly();
  }
}

public enum Plant
{
  Violets,
  Radishes,
  Clover,
  Grass
}