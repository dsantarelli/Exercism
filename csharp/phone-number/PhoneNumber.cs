using System;
using System.Text.RegularExpressions;

public class PhoneNumber
{
  public static string Clean(string number) => number
      .Digits()
      .CheckLength()
      .CheckCountryCode()
      .RemoveCountryCode()
      .CheckAreaCode()
      .CheckExchangeCode();
}

internal static class PhoneNumberExtensions
{
  internal static string Digits(this string number)
    => Regex.Replace(number, "[^0-9]", String.Empty).Trim();

  internal static string CheckLength(this string number)
  {
    if (!(number.Length == 10 || number.Length == 11))
      throw new ArgumentException($"Invalid number length: {number.Length}");
    return number;
  }

  internal static string CheckCountryCode(this string number)
  {
    if (number.Length == 11)
    {
      var countryCode = number[0].ToString();
      if (countryCode != "1")
        throw new ArgumentException($"Invalid country code: {countryCode}");
    }
    return number;
  }

  internal static string RemoveCountryCode(this string number)
    => (number.Length == 11) ? number.Substring(1) : number;

  internal static string CheckAreaCode(this string number)
  {
    var code = number[0];
    if (code == '0' || code == '1')
      throw new ArgumentException($"Invalid area code: {code}");
    return number;
  }

  internal static string CheckExchangeCode(this string number)
  {
    var code = number[3];
    if (code == '0' || code == '1')
      throw new ArgumentException($"Invalid exchange code: {code}");
    return number;
  }
}