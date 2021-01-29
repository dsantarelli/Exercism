import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix {
    
    private final Set<MatrixCoordinate> saddlePoints;

    public Matrix(List<List<Integer>> matrix) {

      List<Integer> maxRowValues = matrix.stream()
        .map(x -> x.stream().max(Integer::compare).get())
        .collect(Collectors.toList());

      List<Integer> minColumnValues = IntStream
        .range(0, matrix.size() > 0 ? matrix.get(0).size() : 0).boxed()
        .map(col -> matrix.stream().map(row -> row.get(col)).min(Integer::compare).get())
        .collect(Collectors.toList());

      saddlePoints = IntStream
          .range(0, matrix.size())
          .mapToObj(x -> IntStream
             .range(0, matrix.get(x).size())
             .filter(y -> matrix.get(x).get(y) == maxRowValues.get(x) && 
                          matrix.get(x).get(y) == minColumnValues.get(y))
             .mapToObj(y -> new MatrixCoordinate(x, y)))
          .flatMap(x -> x)
          .collect(Collectors.toSet());
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}