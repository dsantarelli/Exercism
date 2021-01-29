import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int number) {
        return (int)Math.pow(IntStream.rangeClosed(1, number).sum(), 2);
    }

    public int computeSumOfSquaresTo(int number) {
        return IntStream.rangeClosed(1, number).map(i -> (int)Math.pow(i, 2)).sum();
    }

    public int computeDifferenceOfSquares(int number) {
        return computeSquareOfSumTo(number) - computeSumOfSquaresTo(number);
    }
}