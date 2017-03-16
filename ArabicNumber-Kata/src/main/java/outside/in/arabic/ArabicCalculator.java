package outside.in.arabic;

public class ArabicCalculator {

    private ArabicConversion conversions;

    public ArabicCalculator(ArabicConversion conversions) {
        this.conversions = conversions;
    }

    public int calculate(String romanNumeral) {
        int total = 0;
        int maxValue = 0;

        return calculateValue(total, maxValue, romanNumeral);
    }

    private int calculateValue(int total, int maxValue, String romanNumeral) {
        int numeralLength = romanNumeral.length();

        if (numeralLength > 0) {
            String letter = romanNumeral.substring(numeralLength - 1);
            int value = conversions.getTable().get(letter);

            if (value >= maxValue) {
                total += value;
                maxValue = value;
            } else {
                total -= value;
            }

            return calculateValue(total, maxValue, romanNumeral.substring(0, numeralLength - 1));
        }

        return total;
    }
}
