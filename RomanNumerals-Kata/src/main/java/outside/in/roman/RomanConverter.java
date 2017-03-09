package outside.in.roman;

public class RomanConverter {

    private final RomanCalculator romanCalculator;

    public RomanConverter(RomanCalculator romanCalculator) {
        this.romanCalculator = romanCalculator;
    }

    public String convert(int number) {
        return romanCalculator.calculate(number);
    }
}
