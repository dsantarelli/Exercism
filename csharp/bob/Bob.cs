using System;
using System.Text.RegularExpressions;

public static class Bob
{
  public static string Response(string input)
  {
    var statement = input.Trim();

    if (String.IsNullOrWhiteSpace(statement))
      return "Fine. Be that way!";

    if (Regex.Matches(statement, @"[a-zA-Z]").Count > 0 &&
        statement.ToUpperInvariant() == statement)
    {
      return statement.EndsWith("?") ? 
        "Calm down, I know what I'm doing!" : 
        "Whoa, chill out!";
    }
    
    return statement.EndsWith("?") ? "Sure." : "Whatever.";
  }
}