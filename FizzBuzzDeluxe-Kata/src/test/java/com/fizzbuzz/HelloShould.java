package com.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloShould {

    @Test
    public void return_hello_to_param() {
        assertThat(Hello.hello("John"), is("Hello, John!"));
    }
}
