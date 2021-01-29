class Triangle {

  private final TriangleKind kind;

  Triangle(double side1, double side2, double side3) throws TriangleException {

    if (!checkLengths(side1, side2, side3))
      throw new TriangleException("All sides have to be of length > 0");

    if (!checkSumOfLengths(side1, side2, side3))
      throw new TriangleException(
          "The sum of the lengths of any two sides must be greater than or equal to the length of the third side.");

    if (isDegenerate(side1, side2, side3))
      throw new TriangleException("This is a degenerate triangle");

    kind = isEquilateral(side1, side2, side3) ? 
        TriangleKind.EQUILATERAL
        : isIsosceles(side1, side2, side3) ? 
            TriangleKind.ISOSCELES : 
              TriangleKind.SCALENE;
  }

  private static boolean checkLengths(double side1, double side2, double side3) {
    return (side1 > 0 && side2 > 0 && side3 > 0);
  }

  private static boolean checkSumOfLengths(double side1, double side2, double side3) {
    return side1 + side2 >= side3 && side1 + side3 >= side2 && side2 + side3 >= side1;
  }

  private static boolean isDegenerate(double side1, double side2, double side3) {
    return side1 + side2 == side3 || side1 + side3 == side2 || side2 + side3 == side1;
  }

  private static boolean isEquilateral(double side1, double side2, double side3) {
    return side1 == side2 && side2 == side3;
  }

  private static boolean isIsosceles(double side1, double side2, double side3) {
    return side1 == side2 || side2 == side3 || side1 == side3;
  }

  TriangleKind getKind() {
    return kind;
  }
}
