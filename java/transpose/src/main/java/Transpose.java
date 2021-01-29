import java.util.Arrays;

public class Transpose {

  public String transpose(String input) {

    String[] lines = input.split("\n");
    int rows = lines.length;
    int columns = Arrays.stream(lines).map(x -> x.length()).max(Integer::compare).get();
    char[][] matrix = new char[rows][columns];

    for (int i = 0; i < rows; i++)
      for (int j = 0; j < columns; j++)
        matrix[i][j] = lines[i].length() > j ? lines[i].charAt(j) : ' ';

    String output = "";
    for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++) output += matrix[j][i];
      if (i < columns - 1) output += "\n";
    }
    return output.trim();
  }
}