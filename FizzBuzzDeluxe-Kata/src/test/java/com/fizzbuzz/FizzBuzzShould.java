package com.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzShould {

    @Test
    @Parameters({"6, fizz",
            "13, fizz",
            "31, fizz",
            "10, buzz",
            "59, buzz",
            "60, fizz buzz",
            "53, fizz buzz",
            "546, fizz buzz",
            "1, 1",
            "36, fizz deluxe",
            "50, buzz deluxe",
            "85, fake deluxe",
            "3510, fizz buzz deluxe"

    })
    public void calculate_fizz_buzz(Integer number, String output) {
        assertThat(FizzBuzz.fizzBuzz(number), is(output));
    }
}
