package com.merchant.util;

import com.merchant.ConversionTable;
import com.merchant.domain.GalaxyNumber;
import com.merchant.domain.Unit;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorShould {

    private Calculator calculator;

    private ConversionTable conversion;

    @Before
    public void setUp() throws Exception {
        conversion = new ConversionTable();
        calculator = new Calculator(conversion, RomanConverter.getInstance());
        conversion.addNumber("glob", "I");
        conversion.addNumber("prok", "V");
        conversion.addNumber("pish", "X");
        conversion.addNumber("tegj", "L");
        conversion.addUnit("Silver", new Unit(17, "Credits"));
        conversion.addUnit("Gold", new Unit(14450, "Credits"));
    }

    @Test
    public void calculateValue_when_galaxianNumbersAreGiven() {
        String number = "pish tegj glob glob";
        GalaxyNumber expectedGalaxyNumber =
                new GalaxyNumber("pish tegj glob glob", 42, Optional.empty());

        GalaxyNumber actualGalaxyNumber = calculator.calculate(number);

        assertEquals(expectedGalaxyNumber, actualGalaxyNumber);
    }

    @Test
    public void calculateCredits_when_galaxianNumbersWithUnitsAreGiven() {
        String number = "glob prok Silver";
        GalaxyNumber expectedGalaxyNumber =
                new GalaxyNumber("glob prok Silver", 68, Optional.of("Credits"));

        GalaxyNumber actualGalaxyNumber = calculator.calculate(number, "Credits");

        assertEquals(expectedGalaxyNumber, actualGalaxyNumber);
    }

    @Test
    public void calculateMetal_when_galaxianNumberWithMetalIsGiven() {
        String number = "glob Gold";

        GalaxyNumber expectedGalaxyNumber =
                new GalaxyNumber("glob Gold", 850, Optional.of("Silver"));

        GalaxyNumber actualGalaxyNumber = calculator.calculate(number, "Silver");

        assertEquals(expectedGalaxyNumber, actualGalaxyNumber);
    }
}
