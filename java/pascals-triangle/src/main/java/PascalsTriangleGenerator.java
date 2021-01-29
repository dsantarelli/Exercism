import java.util.stream.IntStream;

public class PascalsTriangleGenerator {

  public int[][] generateTriangle(int rows) {
    if (rows < 0) throw new IllegalArgumentException();    
    int[][] triangle = new int[rows][];         
    IntStream.rangeClosed(1, rows).forEach(i -> triangle[i-1] = buildRow(i));       
    return triangle;
  }
  
  private static int[] buildRow(int row) {                 
    int[] firstHalf = IntStream
        .range(0, (row / 2) + (row % 2))
        .map(i -> (row * i) + (i % 2 == 0 ? 1 : -1))
        .toArray();
          
    int[] secondHalf = IntStream
        .range(0, firstHalf.length)
        .map(i -> firstHalf[0 - i + firstHalf.length - 1])
        .skip(row % 2)
        .toArray();
                
    int[] output = new int[firstHalf.length + secondHalf.length];
    System.arraycopy(firstHalf, 0, output, 0, firstHalf.length);
    System.arraycopy(secondHalf, 0, output, firstHalf.length, secondHalf.length);
    return output;
  }
}