using System;
using System.Collections.Generic;
using System.Linq;

public static class BookStore
{
  private const int BOOK_PRICE = 8;
  private static readonly Dictionary<int, int> _discounts = new Dictionary<int, int>()
  {
    { 5, 25 },
    { 4, 20 },
    { 3, 10 },
    { 2, 5 }
  };

  public static double Total(IEnumerable<int> books) => RecursiveTotal(books.ToList(), 0);

  private static double RecursiveTotal(IEnumerable<int> books, double subTotal)
  {
    if (!books.Any()) return subTotal;
    var minTotal = double.MaxValue;
    var distinctBooks = DistinctBooks(books).ToArray();
    for (int i = distinctBooks.Count(); i >= 1; i--)
    {
      var remaining = books.ToList();

      foreach (var item in distinctBooks.Take(i).ToArray())
        remaining.Remove(item);

      var newTotal = RecursiveTotal(remaining, subTotal + GetCostForDifferentBooks(i));
      minTotal = Math.Min(minTotal, newTotal);
    }
    return minTotal;
  }

  private static IEnumerable<int> DistinctBooks(IEnumerable<int> books)
      => books.GroupBy(x => x).Select(x => x.Key);

  private static double GetCostForDifferentBooks(int differentBooks)
  {
    return BOOK_PRICE
      * differentBooks
      * (100 - (_discounts.ContainsKey(differentBooks) ? _discounts[differentBooks] : 0))
      / 100.0;
  }
}