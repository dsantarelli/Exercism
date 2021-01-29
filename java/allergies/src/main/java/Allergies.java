import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Allergies {

  private final List<Allergen> allergens;

  public Allergies(int score) {
    allergens = Collections.unmodifiableList(Arrays
        .stream(Allergen.values())
        .filter(x -> (score & x.getScore()) == x.getScore())
        .collect(Collectors.toList()));
  }

  public boolean isAllergicTo(Allergen allergen) {
    return allergens.contains(allergen);
  }

  public List<Allergen> getList() {
    return allergens;
  }
}