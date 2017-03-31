package outside.in.luhn;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Splitter {

    private List<Integer> passed = new LinkedList<>();
    private List<Integer> notPassed = new LinkedList<>();

    public void splitBy(String cardNumber, Predicate<Integer> test) {
        IntStream.range(0, cardNumber.length())
                .forEach(item -> {
                    if (test.test(item)) {
                        this.passed.add(Character.getNumericValue(cardNumber.charAt(item)));
                        return;
                    }
                    this.notPassed.add(Character.getNumericValue(cardNumber.charAt(item)));
                });
    }

    public List<Integer> getPassed() {
        return this.passed;
    }

    public List<Integer> getNotPassed() {
        return this.notPassed;
    }
}
