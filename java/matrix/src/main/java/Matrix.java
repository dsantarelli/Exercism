import java.util.Arrays;
import java.util.Vector;
import java.util.stream.Collectors;

public class Matrix {

  private final Vector<Vector<Integer>> matrix;

  public Matrix(String matrixAsString) {
    if (matrixAsString == null)
      throw new IllegalArgumentException("matrixAsString can't be null");

    this.matrix = new Vector<Vector<Integer>>();
    Arrays
    .stream(matrixAsString.trim().split("\\r?\\n"))
    .forEach(rowString -> matrix.addElement(parseRow(rowString)));
  }

  private static Vector<Integer> parseRow(String rowString) {
    Vector<Integer> row = new Vector<Integer>();
    row.addAll(Arrays
        .stream(rowString.split("\\s+"))
        .map(Integer::valueOf)
        .collect(Collectors.toList()));
    return row;
  }

  public int[] getRow(int i) {
    return matrix
        .get(i)
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  public int[] getColumn(int i) {
    return matrix
        .stream()
        .map(x -> x.get(i))
        .mapToInt(Integer::intValue)
        .toArray();
  }

  public int getRowsCount() {
    return matrix.size();
  }

  public int getColumnsCount() {
    return matrix.get(0).size();
  }
}
