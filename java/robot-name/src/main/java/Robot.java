import java.util.Random;

public class Robot {

  private String name;

  public Robot() {
    reset();
  }

  public String getName() {
    return name;
  }

  public void reset() {
    name = generateName();
  }

  private static String generateName() {
    return 
        generateRandomLetter() + 
        generateRandomLetter() + 
        generateRandomNumber() + 
        generateRandomNumber() + 
        generateRandomNumber();
  }

  private static String generateRandomLetter() {
    return String.valueOf((char) (new Random().nextInt(26) + 'A'));
  }

  private static String generateRandomNumber() {
    return String.valueOf(new Random().nextInt(9));
  }
}