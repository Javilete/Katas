package com.merchant.domain;

import java.util.Optional;

public class GalaxyNumber {

    private final double arabicValue;
    private final String value;
    private final Optional<String> unit;

    public GalaxyNumber(String value, double arabicValue, Optional<String> unit) {
        this.value = value;
        this.arabicValue = arabicValue;
        this.unit = unit;
    }

    @Override
    public String toString() {
        String number = this.value + " is " + String.format("%.0f", this.arabicValue);

        return this.unit.isPresent() ? number + " " + this.unit.get() : number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GalaxyNumber)) return false;

        GalaxyNumber that = (GalaxyNumber) o;

        if (Double.compare(that.arabicValue, arabicValue) != 0) return false;
        if (!value.equals(that.value)) return false;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(arabicValue);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + value.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }
}
