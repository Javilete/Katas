package com.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SumShould {

    @Test
    public void compute_sum_of_two_valid_integers() {
        assertThat(Sum.sum(1, 1), equalTo(2));
    }

    @Test(expected = RuntimeException.class)
    public void throw_an_exception_when_first_param_is_not_between_zero_and_100() {
        Sum.sum(-1, 1);
    }

    @Test(expected = RuntimeException.class)
    public void throw_an_exception_when_second_param_is_not_between_zero_and_100() {
        Sum.sum(1, 101);
    }
}