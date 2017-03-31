package outside.in.luhn;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class GuidingTest {

    private LuhnVerifier verifier;
    private Operator provider;
    private Splitter splitter;

    @Before
    public void setUp() throws Exception {
        provider = new Operator();
        splitter = new Splitter();
        verifier = new LuhnVerifier(provider, splitter);
    }

    @Test
    public void shouldVerifyLuhnTestPassesForAcorrectCardNumber() {
        String cardNumber = "49927398716";
        Predicate<Integer>  splittingCondition = i -> i % 2 == 0;

        assertTrue(verifier.isValid(cardNumber, splittingCondition));
    }
}
