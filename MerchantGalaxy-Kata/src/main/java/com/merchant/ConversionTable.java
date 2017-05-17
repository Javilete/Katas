package com.merchant;

import com.merchant.domain.Unit;

import java.util.HashMap;
import java.util.Map;

public class ConversionTable {

    private Map<String, String> numbers = new HashMap<>();
    private Map<String, Unit> units = new HashMap<>();

    public void addNumber(String key, String value) {
        this.numbers.put(key, value);
    }

    public void addUnit(String key, Unit value) {
        this.units.put(key, value);
    }

    public Map<String, String> getNumbers() {
        return this.numbers;
    }

    public Map<String, Unit> getUnits() {
        return this.units;
    }
}
