package outside.in.roman;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RomanConverterTest {

    private RomanConverter romanConverter;

    @Mock
    private RomanCalculator romanCalculator;

    @Before
    public void setUp() throws Exception {
        romanConverter = new RomanConverter(romanCalculator);
    }

    @Test
    public void name() {
        int number = 1984;

        romanConverter.convert(number);

        verify(romanCalculator).calculate(anyInt());
    }
}
