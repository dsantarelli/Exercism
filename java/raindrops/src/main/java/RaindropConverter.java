class RaindropConverter {

    String convert(int number) {
        String output = "";
        if (isFactor(number, 3)) output += "Pling";
        if (isFactor(number, 5)) output += "Plang";
        if (isFactor(number, 7)) output += "Plong";
        return output == "" ? String.valueOf(number) : output;
    }

    private static boolean isFactor(int number, int factor) {
        return number % factor == 0;
    }
}