package outside.in.roman;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidanceTest {

    private RomanConverter romanConverter;
    private RomanConversion conversion;
    private RomanCalculator calculator;

    @Before
    public void setUp() throws Exception {
        conversion = new RomanConversion();
        calculator = new RomanCalculator(conversion);
        romanConverter = new RomanConverter(calculator);
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfOne() {
        int number = 1;

        String roman = romanConverter.convert(number);

        assertThat(roman, is("I"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfThree() {
        int number = 3;

        String roman = romanConverter.convert(number);

        assertThat(roman, is("III"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_SingleDigitGivenOfNine() {
        int number = 9;

        String roman = romanConverter.convert(number);

        assertThat(roman, is("IX"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_givenOneThousanSixtySix() {
        int number = 1066;

        String roman = romanConverter.convert(number);

        assertThat(roman, is("MLXVI"));
    }

    @Test
    public void shouldReturnRomanNumerals_when_givenOneThousanNineHundredEightyNince() {
        int number = 1989;

        String roman = romanConverter.convert(number);

        assertThat(roman, is("MCMLXXXIX"));
    }
}
