package outside.in.arabic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArabicConverterTest {

    @Mock
    private ArabicCalculator parser;

    private ArabicConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new ArabicConverter(parser);
    }

    @Test
    public void shouldCallParser_when_aRomanNumeralGiven() {
        String romanNumeral = "X";

        converter.convert(romanNumeral);

        verify(parser).calculate(eq(romanNumeral));
    }
}
