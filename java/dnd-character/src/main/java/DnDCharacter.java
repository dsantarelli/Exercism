import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {

  private Random random = new Random();
  private int strength, dexterity, constitution, intelligence, wisdom, charisma;

  DnDCharacter() {
    this.strength = ability();
    this.dexterity = ability();
    this.constitution = ability();
    this.intelligence = ability();
    this.wisdom = ability();
    this.charisma = ability();
  }

  int ability() {
    return IntStream
        .range(0, 4)
        .map(i -> rollDice())
        .sorted()
        .skip(1)
        .sum();
  }

  int modifier(int input) {
    return Math.floorDiv(input - 10, 2);
  }

  public int getStrength() {
    return strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public int getHitpoints() {
    return 10 + modifier(constitution);
  }

  private int rollDice() {
    return random.nextInt(6) + 1;
  }
}
