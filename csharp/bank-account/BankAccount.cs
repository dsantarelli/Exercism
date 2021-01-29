using System;

public class BankAccount
{
  private readonly object _lock = new object();
  private bool _isOpen;
  private decimal _balance;

  public void Open() => _isOpen = true;

  public void Close() => _isOpen = false;

  public decimal Balance => GetBalance();

  private decimal GetBalance()
  {
    lock (_lock)
    {
      EnsureThatAccountIsOpen();
      return _balance;
    }
  }

  public void UpdateBalance(decimal change)
  {
    lock (_lock)
    {
      EnsureThatAccountIsOpen();
      _balance += change;
    }
  }

  private void EnsureThatAccountIsOpen()
  {
    if (!_isOpen) throw new InvalidOperationException("BankAccount is closed.");
  }
}
