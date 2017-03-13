package outside.in.roman;

public class RomanCalculator {

    private RomanConversion conversion;

    public RomanCalculator(RomanConversion conversion) {
        this.conversion = conversion;
    }

    public String calculate(int arabicNumber) {
        StringBuffer romanNumeral = new StringBuffer();
        return calculateValue(arabicNumber, romanNumeral);
    }

    private String calculateValue(int arabicNumber, StringBuffer romanNumeral) {
        if(arabicNumber > 0) {
            int hightestValue = findHighestValueLessThan(arabicNumber);
            romanNumeral.append(conversion.getTable().get(hightestValue));
            return calculateValue(arabicNumber - hightestValue, romanNumeral);
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
