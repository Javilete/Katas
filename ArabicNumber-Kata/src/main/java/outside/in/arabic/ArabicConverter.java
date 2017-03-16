package outside.in.arabic;

public class ArabicConverter {

    private final ArabicCalculator calculator;

    public ArabicConverter(ArabicCalculator calculator) {
        this.calculator = calculator;
    }

    public int convert(String romanNumberal) {
        return calculator.calculate(romanNumberal);
    }
}
