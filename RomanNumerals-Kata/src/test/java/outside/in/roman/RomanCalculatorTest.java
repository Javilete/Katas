package outside.in.roman;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RomanCalculatorTest {

    private RomanConversion conversion;
    private RomanCalculator calculator;

    @Before
    public void setUp() throws Exception {
        conversion = new RomanConversion();
        calculator = new RomanCalculator(conversion);
    }

    @Test
    public void shouldGiveMeRomanNumeral_when_aExistingConversionIsGiven() {
        int breakNumber = 1000;

        String romanNumber = calculator.calculate(breakNumber);

        assertThat(romanNumber, is("M"));
    }

    @Test
    public void shouldGiveMeRomanNumeralCalculated_when_aConversionDoesNotExist() {
        int breakNumber = 1996;

        String romanNumber = calculator.calculate(breakNumber);

        assertThat(romanNumber, is("MCMXCVI"));
    }
}
