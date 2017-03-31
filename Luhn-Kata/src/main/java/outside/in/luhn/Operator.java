package outside.in.luhn;

import java.util.List;

public class Operator {

    public String reverseNumber(String cardNumber) {
        return new StringBuilder(cardNumber)
                .reverse()
                .toString();
    }

    public int calculateOdd(List<Integer> oddDigits) {
        return oddDigits.stream()
                .mapToInt(i -> i)
                .sum();
    }

    public int calculateEven(List<Integer> evenDigits) {
        return evenDigits.stream()
                .mapToInt(i -> i)
                .map(digit -> digit * 2)
                .map(multiplied -> splitDigit(String.valueOf(multiplied)))
                .sum();
    }

    private int splitDigit(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
