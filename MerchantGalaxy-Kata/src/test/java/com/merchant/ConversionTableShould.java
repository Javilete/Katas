package com.merchant;


import com.merchant.domain.Unit;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConversionTableShould {

    private ConversionTable conversion;

    @Before
    public void setUp() throws Exception {
        conversion = new ConversionTable();
    }

    @Test
    public void addAnewNumberToTheNumbersMap() {
        conversion.addNumber("glob", "I");

        assertThat(conversion.getNumbers().get("glob"), is("I"));
    }

    @Test
    public void addAnewUnitToTheUnitsMap() {
        Unit unit = new Unit(17, "Silver");

        conversion.addUnit("Silver", unit);

        assertThat(conversion.getUnits().get("Silver"), is(unit));
    }
}
