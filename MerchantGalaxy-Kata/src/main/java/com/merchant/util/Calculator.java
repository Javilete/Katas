package com.merchant.util;

import com.merchant.ConversionTable;
import com.merchant.domain.Unit;
import com.merchant.domain.GalaxyNumber;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Calculator {

    private static final String SPLITTER = "\\s+";

    private ConversionTable conversion;
    private RomanConverter romanConverter;

    public Calculator(ConversionTable conversion, RomanConverter romanConverter) {
        this.conversion = conversion;
        this.romanConverter = romanConverter;
    }

    public GalaxyNumber calculate(String galaxyTextNumber) {
        String[] tokens = galaxyTextNumber.split(SPLITTER);
        double result = getArabicValue(tokens);

        return new GalaxyNumber(galaxyTextNumber, result, Optional.empty());
    }


    public GalaxyNumber calculate(String galaxyTextNumber, String galaxyTargetUnit) {
        String[] tokens = galaxyTextNumber.split(SPLITTER);

        double result = getArabicValue(tokens);

        Map<String, Unit> units = conversion.getUnits();
        Unit numberUnit = units.get(tokens[tokens.length - 1]);
        Unit resultUnit = units.get(galaxyTargetUnit);

        result = result * numberUnit.getValue();
        if(resultUnit != null) {
            result = result / resultUnit.getValue();
        }

        return new GalaxyNumber(galaxyTextNumber, result, Optional.of(galaxyTargetUnit));
    }

    private double getArabicValue(String[] tokens) {
        Map<String, String> numbers = conversion.getNumbers();

        String romanNumber = Arrays.asList(tokens).stream()
                .filter(numbers::containsKey)
                .map(numbers::get)
                .collect(Collectors.joining());
        return romanConverter.convert(romanNumber);
    }
}
