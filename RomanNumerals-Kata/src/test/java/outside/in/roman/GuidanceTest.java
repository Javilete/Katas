package outside.in.roman;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidanceTest {

    private RomanConversion conversion;
    private RomanConverter calculator;

    @Before
    public void setUp() throws Exception {
        conversion = new RomanConversion();
        calculator = new RomanConverter(conversion);
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfOne() {
        int number = 1;

        String roman = calculator.convert(number);

        assertThat(roman, is("I"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfThree() {
        int number = 3;

        String roman = calculator.convert(number);

        assertThat(roman, is("III"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfNine() {
        int number = 9;

        String roman = calculator.convert(number);

        assertThat(roman, is("IX"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_givenOneThousanSixtySix() {
        int number = 1066;

        String roman = calculator.convert(number);

        assertThat(roman, is("MLXVI"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_givenOneThousanNineHundredEightyNince() {
        int number = 1989;

        String roman = calculator.convert(number);

        assertThat(roman, is("MCMLXXXIX"));
    }
}
