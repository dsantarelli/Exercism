public class BinarySearch
{
  private readonly int[] _input;

  public BinarySearch(int[] input) => _input = input;

  public int Find(int value)
  {
    var found = false;
    var first = 0;
    var last = _input.Length - 1;
    var mid = 0;

    while (!found && first <= last)
    {
      mid = (first + last) / 2;
      if (value == _input[mid])
      {
        found = true;
        break;
      }
      if (value < _input[mid]) last = mid - 1;
      else first = mid + 1;
    }
    return found ? mid : -1;
  }
}