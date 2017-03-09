package outside.in.roman;

public class RomanCalculator {

    private RomanConversion conversion;

    public RomanCalculator(RomanConversion conversion) {
        this.conversion = conversion;
    }

    public String calculate(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();

        while (arabicNumber > 0) {
            int hightestValue = findHighestValueLessThan(arabicNumber);
            romanNumeral.append(conversion.getTable().get(hightestValue));
            arabicNumber = arabicNumber - hightestValue;
        }

        return romanNumeral.toString();
    }

    private int findHighestValueLessThan(int arabicNumber) {
        return conversion.getTable().keySet().stream()
                .mapToInt(key -> key)
                .filter(i -> i <= arabicNumber)
                .max()
                .getAsInt();
    }
}
