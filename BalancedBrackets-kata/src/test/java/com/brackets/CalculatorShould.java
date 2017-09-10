package com.brackets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorShould {

    @Mock
    private Splitter splitter;

    @Mock
    private Balancer balancer;

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(splitter, balancer);
    }

    @Test
    public void shouldCallSplitterToGetEntries() {
        String input = "3\n" +
                "{[()]}\n" +
                "{[(])}\n" +
                "{{[[(())]]}}";

        calculator.calculateOutput(input);

        verify(splitter).split(input);
    }

    @Test
    public void shouldCallCalculatorForEachEntry() {
        String input = "3\n" +
                "{[()]}\n" +
                "{[(])}\n" +
                "{{[[(())]]}}";
        when(splitter.split(input)).thenCallRealMethod();

        calculator.calculateOutput(input);

        verify(balancer).isBalanced("{[()]}");
    }
}
