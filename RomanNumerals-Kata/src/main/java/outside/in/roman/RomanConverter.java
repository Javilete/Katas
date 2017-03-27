package outside.in.roman;

public class RomanConverter {

    private RomanConversion conversion;

    public RomanConverter(RomanConversion conversion) {
        this.conversion = conversion;
    }

    public String convert(int arabicNumber) {
        StringBuffer romanNumeral = new StringBuffer();
        return convertPartial(arabicNumber, romanNumeral);
    }

    private String convertPartial(int arabicNumber, StringBuffer romanNumeral) {
        if (arabicNumber > 0) {
            int hightestValue = findHighestValueLessThan(arabicNumber);
            romanNumeral.append(conversion.getTable().get(hightestValue));
            return convertPartial(arabicNumber - hightestValue, romanNumeral);
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
