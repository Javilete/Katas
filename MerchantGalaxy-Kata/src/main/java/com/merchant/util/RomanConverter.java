package com.merchant.util;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

    private static final RomanConverter INSTANCE = new RomanConverter();

    private Map<String, Integer> conversions = new HashMap<>();

    private RomanConverter() {
        conversions.put("I", 1);
        conversions.put("V", 5);
        conversions.put("X", 10);
        conversions.put("L", 50);
        conversions.put("C", 100);
        conversions.put("D", 500);
        conversions.put("M", 1000);
    }

    public int convert(String numeral) {
        int result = 0;
        int maxValue = 0;

        return calculateValue(result, maxValue, numeral);
    }

    private int calculateValue(int result, int maxValue, String numeral) {
        int numeralLength = numeral.length();

        if (numeralLength > 0) {
            String letter = numeral.substring(numeralLength - 1);
            int value = conversions.get(letter);

            if (value >= maxValue) {
                result += value;
                maxValue = value;
            } else {
                result -= value;
            }

            return calculateValue(result, maxValue, numeral.substring(0, numeralLength - 1));
        }

        return result;
    }

    public static RomanConverter getInstance() {
        return RomanConverter.INSTANCE;
    }
}
