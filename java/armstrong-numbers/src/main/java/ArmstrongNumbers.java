import java.util.stream.IntStream;

class ArmstrongNumbers {
  boolean isArmstrongNumber(int numberToCheck) {
    char[] chars = String.valueOf(numberToCheck).toCharArray();
    int power = chars.length;
    return IntStream
        .range(0, power)
        .map(i -> (int)Math.pow(Character.getNumericValue(chars[i]), power))
        .sum() == numberToCheck;
  }
}