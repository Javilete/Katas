package com.merchant;

import com.merchant.ConversionTable;
import com.merchant.util.Calculator;
import com.merchant.util.Console;
import com.merchant.util.GalaxyTranslator;
import com.merchant.util.Parser;
import com.merchant.util.RomanConverter;

public class GalaxyGuide {

    public static void main(String[] args) {
        if (args.length > 0) {
            String notes = args[0];

            ConversionTable conversion = new ConversionTable();
            RomanConverter converter = RomanConverter.getInstance();
            Console console = new Console();
            Calculator calculator = new Calculator(conversion, converter);

            Parser parser = new Parser.Builder().withConversionTable(conversion)
                    .withRomanConverter(converter)
                    .withCalculator(calculator)
                    .withConsole(console)
                    .build();
            GalaxyTranslator translator = new GalaxyTranslator(parser);

            translator.read(notes);
        } else {
            System.out.println("Please, provide the path to the notes");
        }
    }
}
