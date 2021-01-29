public class Bob {

  public String hey(String input) {

    if (input.trim().isEmpty())
      return "Fine. Be that way!";

    if (input.toUpperCase().equals(input) && 
        !input.matches("^[\\s+\\p{Punct}[0-9]]*$"))
      return "Whoa, chill out!";

    if (input.endsWith("?"))
      return "Sure.";

    return "Whatever.";
  }
}
