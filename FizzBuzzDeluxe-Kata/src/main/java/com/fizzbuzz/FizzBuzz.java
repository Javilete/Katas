package com.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FizzBuzz {

    private static final String FIVE = "5";
    private static final String THREE = "3";
    private static final String SPACE = " ";

    static Map<Predicate<Integer>, String> dictionary = new LinkedHashMap<>();

    static Predicate<Integer> fake = number -> number % 2 != 0;
    static Predicate<Integer> fizz = number -> number % 3 == 0 || contains(THREE, number);
    static Predicate<Integer> buzz = number -> number % 5 == 0 || contains(FIVE, number);
    static Predicate<Integer> fizzDeluxe = number -> isDeluxe(number, Category.FIZZ);
    static Predicate<Integer> buzzDeluxe = number -> isDeluxe(number, Category.BUZZ);
    static Predicate<Integer> fakeDeluxe = fake.and(fizzDeluxe.or(buzzDeluxe));


    static {
        dictionary.put(fizz, "fizz");
        dictionary.put(buzz, "buzz");
        dictionary.put(fakeDeluxe, "fake");
        dictionary.put(fizzDeluxe, "deluxe");
        dictionary.put(buzzDeluxe, "deluxe");
    }

    public static String fizzBuzz(Integer number) {
        String result = dictionary.keySet().stream()
                .filter(p -> p.test(number))
                .map(p -> dictionary.get(p))
                .distinct()
                .collect(Collectors.joining(SPACE));


        return result.isEmpty() ? String.valueOf(number) : isFake(result);
    }

    private static String isFake(String result) {
        if (result.contains("fake")) {
            return "fake deluxe";
        }
        return result;
    }

    private static boolean isDeluxe(Integer number, Category category) {
        return number % category.getNumber() == 0 && contains(category.getValue(), number);
    }

    private static boolean contains(String value, Integer number) {
        return String.valueOf(number)
                .contains(value);
    }
}