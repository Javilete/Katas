package outside.in.luhn;

import java.util.function.Predicate;

public class LuhnVerifier {

    private Operator provider;
    private Splitter splitter;

    public LuhnVerifier(Operator provider, Splitter splitter) {
        this.provider = provider;
        this.splitter = splitter;
    }

    public boolean isValid(String cardNumber, Predicate<Integer> condition) {
        String reversedCardNumber = provider.reverseNumber(cardNumber);
        splitter.splitBy(reversedCardNumber, condition);

        int totalCalculation = provider.calculateOdd(splitter.getPassed()) +
                            provider.calculateEven(splitter.getNotPassed());

        return endsWithZero(totalCalculation);
    }

    private boolean endsWithZero(int number) {
        return number % 10 == 0;
    }
}
