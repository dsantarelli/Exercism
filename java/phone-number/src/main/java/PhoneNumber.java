public class PhoneNumber {

  private final static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
  private final static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "Can only have 11 digits if number starts with '1'";
  private final static String illegalCharacterExceptionMessage = "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";

  private final String phoneNumber;

  public PhoneNumber(String input) {
    
    if (input.replaceAll("[0-9\\.\\(\\)\\s-]", "").length() > 0)
      throw new IllegalArgumentException(illegalCharacterExceptionMessage);

    String str = input.replaceAll("\\s+|[^\\d+]", "").trim();

    if (!(str.length() == 10 || str.length() == 11))
      throw new IllegalArgumentException(wrongLengthExceptionMessage);

    if (str.length() == 11)
    {
      if (!str.startsWith("1"))
        throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);

      else phoneNumber = str.substring(1); 
    }
    else phoneNumber = str;
  }

  public String getNumber() {
    return phoneNumber;
  }
}