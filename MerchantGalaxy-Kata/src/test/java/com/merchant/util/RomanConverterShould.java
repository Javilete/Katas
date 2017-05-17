package com.merchant.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RomanConverterShould {

    private RomanConverter romanNumeral;

    @Before
    public void setUp() throws Exception {
        romanNumeral = RomanConverter.getInstance();
    }

    @Test
    public void convertIto1() {
        int numeral = romanNumeral.convert("I");

        assertThat(numeral, is(1));
    }

    @Test
    public void convertIIto2() {
        int numeral = romanNumeral.convert("II");

        assertThat(numeral, is(2));
    }

    @Test
    public void convertIIIto3() {
        int numeral = romanNumeral.convert("III");

        assertThat(numeral, is(3));
    }

    @Test
    public void convertVto5() {
        int numeral = romanNumeral.convert("V");

        assertThat(numeral, is(5));
    }

    @Test
    public void convertXto10() {
        int numeral = romanNumeral.convert("X");

        assertThat(numeral, is(10));
    }

    @Test
    public void convertXXto20() {
        int numeral = romanNumeral.convert("XX");

        assertThat(numeral, is(20));
    }

    @Test
    public void convertLto50() {
        int numeral = romanNumeral.convert("L");

        assertThat(numeral, is(50));
    }

    @Test
    public void convertCto100() {
        int numeral = romanNumeral.convert("C");

        assertThat(numeral, is(100));
    }

    @Test
    public void convertDto500() {
        int numeral = romanNumeral.convert("D");

        assertThat(numeral, is(500));
    }

    @Test
    public void convertMto1000() {
        int numeral = romanNumeral.convert("M");

        assertThat(numeral, is(1000));
    }

    @Test
    public void convertIVto4() {
        int numeral = romanNumeral.convert("IV");

        assertThat(numeral, is(4));
    }

    @Test
    public void convertMCMIIIto1903() {
        int numeral = romanNumeral.convert("MCMIII");

        assertThat(numeral, is(1903));
    }


}
