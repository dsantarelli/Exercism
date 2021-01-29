using System;
using System.Collections.Generic;
using System.Linq;

public static class Series
{
  public static string[] Slices(string numbers, int sliceLength)
  {
    if (string.IsNullOrEmpty(numbers)) throw new ArgumentException("numbers cannot be null or empty");
    if (sliceLength <= 0) throw new ArgumentException("sliceLength must be greater than zero");
    if (sliceLength > numbers.Length) throw new ArgumentException("sliceLength must be lower or equal than " + numbers.Length);

    var i = 0;
    var output = new List<string>();
    while ((i + sliceLength) <= numbers.Length)
    {
      output.Add(new string(numbers.Skip(i).Take(sliceLength).ToArray()));
      i++;
    }
    return output.ToArray();
  }
}