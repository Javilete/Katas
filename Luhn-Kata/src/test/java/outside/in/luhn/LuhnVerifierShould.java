package outside.in.luhn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LuhnVerifierShould {

    private static final Predicate<Integer>  SPLITTING_CONDITION = i -> i % 2 == 0;

    private LuhnVerifier verifier;

    @Mock
    private Operator operator;

    @Mock
    private Splitter splitter;

    @Before
    public void setUp() throws Exception {
        verifier = new LuhnVerifier(operator, splitter);
    }

    @Test
    public void shouldCallReverseCardNumberMethodFromStepProvider() {
        String cardNumber = "49927398716";

        verifier.isValid(cardNumber, SPLITTING_CONDITION);

        verify(operator).reverseNumber(eq(cardNumber));
    }

    @Test
    public void shouldCallSplitByFromSplitter() {
        String cardNumber = "61789372994";
        String reversedCardNumber = "49927398716";
        when(operator.reverseNumber(cardNumber)).thenReturn(reversedCardNumber);

        verifier.isValid(cardNumber, SPLITTING_CONDITION);

        verify(splitter).splitBy(eq(reversedCardNumber), any(Predicate.class));
    }

    @Test
    public void shouldAddOddDigits() {
        String cardNumber = "61789372994";
        String reversedCardNumber = "49927398716";
        List<Integer> oddNumbers = Arrays.asList(6, 7, 9, 7, 9, 4);
        when(operator.reverseNumber(cardNumber)).thenReturn(reversedCardNumber);
        when(splitter.getPassed()).thenReturn(oddNumbers);

        verifier.isValid(cardNumber, SPLITTING_CONDITION);

        verify(operator).calculateOdd(oddNumbers);
    }

    @Test
    public void shouldSumEvenDigits() {
        String cardNumber = "61789372994";
        String reversedCardNumber = "49927398716";
        List<Integer> evenNumbers = Arrays.asList(1, 8, 3, 2, 9);
        when(operator.reverseNumber(cardNumber)).thenReturn(reversedCardNumber);
        when(splitter.getNotPassed()).thenReturn(evenNumbers);

        verifier.isValid(cardNumber, SPLITTING_CONDITION);

        verify(operator).calculateEven(evenNumbers);
    }
}
