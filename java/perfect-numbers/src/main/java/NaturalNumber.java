import java.util.stream.IntStream;

public class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) {
        if (number <= 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        this.number = number;
    }

    public Classification getClassification() {

        int aliquotSum = IntStream
            .rangeClosed(1, number / 2)
            .filter(n -> (number % n) == 0)
            .sum();

        if (aliquotSum == number) 
            return Classification.PERFECT;
            
        return (aliquotSum > number) ? 
            Classification.ABUNDANT : 
            Classification.DEFICIENT;
    }
}