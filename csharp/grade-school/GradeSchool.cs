using System;
using System.Linq;
using System.Collections.Generic;

public class GradeSchool
{
  private readonly Dictionary<int, HashSet<string>> _dictionary = new Dictionary<int, HashSet<string>>(); 

  public void Add(string student, int grade)
  {
    if (_dictionary.ContainsKey(grade))
      _dictionary[grade].Add(student);      
    
    else
      _dictionary.Add(grade, new HashSet<string>(new[] { student }, StringComparer.InvariantCultureIgnoreCase));
  }

  public IEnumerable<string> Roster()
  {
    return _dictionary
      .OrderBy(x => x.Key)
      .SelectMany(x => Grade(x.Key));
  }

  public IEnumerable<string> Grade(int grade)
  {
    return _dictionary.ContainsKey(grade) ? 
      _dictionary[grade].OrderBy(x => x) : 
      Enumerable.Empty<string>();
  }
}