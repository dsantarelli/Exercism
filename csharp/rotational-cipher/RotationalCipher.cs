using System.Linq;

public static class RotationalCipher
{
  public static string Rotate(string text, int shiftKey) =>
    new string(text.Select(c => RotateChar(c, shiftKey)).ToArray());

  private static char RotateChar(char c, int shiftKey)
  {
    if ('a' <= c && c <= 'z') return (char)('a' + (c - 'a' + shiftKey) % 26);
    if ('A' <= c && c <= 'Z') return (char)('A' + (c - 'A' + shiftKey) % 26);
    return c;
  }
}