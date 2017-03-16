package outside.in.arabic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArabicCalculatorTest {

    private ArabicConversion conversion;
    private ArabicCalculator arabicCalculator;

    @Before
    public void setUp() throws Exception {
        conversion = new ArabicConversion();
        arabicCalculator = new ArabicCalculator(conversion);
    }

    @Test
    public void shouldParseNumeral_when_aRomanValueIsGiven() {
        String romanNumeral = "MLXVI";

        int arabicNumber = arabicCalculator.calculate(romanNumeral);

        assertThat(arabicNumber, is(1066));
    }

    @Test
    public void shouldParseNumeral_when_aRomanValueWithSubstractionsIsGiven() {
        String romanNumeral = "MCMLXXXIX";

        int arabicNumber = arabicCalculator.calculate(romanNumeral);

        assertThat(arabicNumber, is(1989));
    }
}
