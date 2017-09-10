package com.brackets;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuidingTest {

    private Calculator calculator;
    private Splitter splitter;
    private Balancer balancer;

    @Before
    public void setUp() throws Exception {
        splitter = new Splitter();
        balancer = new Balancer();
        calculator = new Calculator(splitter, balancer);
    }

    @Test
    public void shouldPrintWhetherAlistOfStringsAreBalancedBrackets() {
        String input = "3\n" +
                "{[()]}\n" +
                "{[(])}\n" +
                "{{[[(())]]}}\n";

        String result = calculator.calculateOutput(input);

        assertThat(result, is("YES\n" +
                "NO\n" +
                "YES"));
    }

    @Test
    public void shouldPrintWhetherAlistOfStringsAreBalancedBrackets2() {
        String input = "3\n" +
                "{[()]}\n" +
                "{[(])}\n" +
                "{{[[(())]]}}";

        String result = calculator.calculateOutput(input);

        assertThat(result, is("YES\n" +
                "NO\n" +
                "YES"));
    }


}
