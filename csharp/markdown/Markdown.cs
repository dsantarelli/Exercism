using System.Text.RegularExpressions;

public static class Markdown
{
  public static string Parse(string markdown)
  {
    markdown = Regex.Replace(markdown, "^(#+)(.+)", new MatchEvaluator(m => string.Format("<h{0}>{1}</h{0}>", m.Groups[1].Length, m.Groups[2].Value.Trim())));
    markdown = Regex.Replace(markdown, @"^\*\s*(.+)", "<li>$1</li>", RegexOptions.Multiline);
    markdown = Regex.Replace(markdown, "\n", "", RegexOptions.Singleline);
    markdown = Regex.Replace(markdown, "<li>(.+)</li>", "<ul><li>$1</li></ul>");
    markdown = Regex.Replace(markdown, "^(\\w.+)$", "<p>$1</p>");
    markdown = Regex.Replace(markdown, "__(.+?)__", "<strong>$1</strong>");
    markdown = Regex.Replace(markdown, "_(.+?)_", "<em>$1</em>");
    return markdown;
  }
}