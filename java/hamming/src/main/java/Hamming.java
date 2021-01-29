public class Hamming {

  private final String leftStrand;
  private final String rightStrand;

  Hamming(String leftStrand, String rightStrand) {
    this.leftStrand = leftStrand == null ? "" : leftStrand.trim().toUpperCase();
    this.rightStrand = rightStrand == null ? "" : rightStrand.trim().toUpperCase();
    if (this.leftStrand.length() != this.rightStrand.length())
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
  }

  int getHammingDistance() {
    if (this.leftStrand.isEmpty() || this.rightStrand.isEmpty()) return 0;
    int distance = 0;
    for (int i = 0; i < this.leftStrand.length(); i++) {
      if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
        ++distance;
    }
    return distance;
  }
}
