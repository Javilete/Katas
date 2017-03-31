package outside.in.luhn;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperatorShould {

    private Operator provider;

    @Before
    public void setUp() throws Exception {
        provider = new Operator();
    }

    @Test
    public void shouldReverseCardNumber() {
        String cardNumber = "49927398716";

        String reversedCardNumber = provider.reverseNumber(cardNumber);

        assertThat(reversedCardNumber, is("61789372994"));
    }

    @Test
    public void shouldSumOddDigits() {
        List<Integer> oddNumbers = Arrays.asList(6, 7, 9, 7, 9, 4);

        int oddSum = provider.calculateOdd(oddNumbers);

        assertThat(oddSum, is(42));
    }

    @Test
    public void shouldCalculateTheEvenDigitsSum() {
        List<Integer> evenNumbers = Arrays.asList(1, 8, 3, 2, 9);

        int evenSum = provider.calculateEven(evenNumbers);

        assertThat(evenSum, is(28));
    }
}
