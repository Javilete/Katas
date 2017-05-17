package com.merchant.domain.notes;

import com.merchant.ConversionTable;
import com.merchant.domain.Unit;
import com.merchant.util.RomanConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UnitNote extends Note {

    private ConversionTable conversion;
    private RomanConverter converter;

    public UnitNote(String text, ConversionTable conversion, RomanConverter converter) {
        super(text);
        this.conversion = conversion;
        this.converter = converter;
    }

    @Override
    public void process() {
        String[] tokens = this.text.split("\\s+");
        int number = Integer.valueOf(this.text.replaceAll("[^0-9]", ""));

        Map<String, String> conversionNumbers = conversion.getNumbers();
        int decimalNumber = calculateDecimalNumber(tokens, conversionNumbers);

        Unit unit = createUnit(number, decimalNumber, conversionNumbers, tokens);

        conversion.addUnit(unit.getName(), unit);
    }

    private Unit createUnit(int number, int decimalNumber,
                            Map<String, String> conversionNumbers, String[] tokens) {
        Optional<String> unitFromString = Arrays.asList(tokens).stream()
                .filter(token -> !conversionNumbers.containsKey(token))
                .findFirst();

        return new Unit((double) number / decimalNumber,
                unitFromString.orElseThrow(() -> new RuntimeException("No unit found")));
    }

    private int calculateDecimalNumber(String[] tokens, Map<String, String> numbers) {
        String romanNumber = Arrays.asList(tokens).stream()
                .filter(numbers::containsKey)
                .map(numbers::get)
                .collect(Collectors.joining());

        return converter.convert(romanNumber);
    }
}
