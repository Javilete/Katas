package outside.in.arabic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidingTest {

    private ArabicConverter arabicConverter;
    private ArabicConversion arabicConversion;
    private ArabicCalculator arabicCalculator;

    @Before
    public void setUp() throws Exception {
        arabicConversion = new ArabicConversion();
        arabicCalculator = new ArabicCalculator(arabicConversion);
        arabicConverter = new ArabicConverter(arabicCalculator);
    }

    @Test
    public void shouldReturnArabicValue_when_aRomanNumeralIsGiven() {
        String romanNumberal = "MCMLXXXIX";

        int arabicResult = arabicConverter.convert(romanNumberal);

        assertThat(arabicResult, is(1989));
    }
}
