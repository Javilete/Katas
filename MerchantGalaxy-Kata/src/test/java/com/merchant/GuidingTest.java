package com.merchant;

import com.merchant.util.Calculator;
import com.merchant.util.Console;
import com.merchant.util.GalaxyTranslator;
import com.merchant.util.Parser;
import com.merchant.util.RomanConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class GuidingTest {

    @Mock
    private Console console;

    private Parser parser;
    private ConversionTable conversion;
    private GalaxyTranslator galaxyTranslator;
    private RomanConverter converter;
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        conversion = new ConversionTable();
        converter = RomanConverter.getInstance();
        calculator = new Calculator(conversion, converter);
        parser = new Parser.Builder().withConversionTable(conversion)
                .withRomanConverter(converter)
                .withCalculator(calculator)
                .withConsole(console)
                .build();
        galaxyTranslator = new GalaxyTranslator(parser);
    }

    @Test
    public void shouldReturnTheValueWhenAquestionIsGiven() {
        String input = "./src/test/resources/notes.txt";

        galaxyTranslator.read(input);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).print(eq("pish tegj glob glob is 42"));
        inOrder.verify(console).print(eq("glob prok Silver is 68 Credits"));
        inOrder.verify(console).print(eq("glob prok Gold is 57800 Credits"));
        inOrder.verify(console).print(eq("glob prok Iron is 782 Credits"));
        inOrder.verify(console).print(eq("glob Gold is 850 Silver"));
        inOrder.verify(console).print(eq("I have no idea what you are talking about"));
    }
}
