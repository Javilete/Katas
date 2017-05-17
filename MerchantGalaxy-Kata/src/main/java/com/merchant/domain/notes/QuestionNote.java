package com.merchant.domain.notes;

import com.merchant.domain.GalaxyNumber;
import com.merchant.util.Calculator;
import com.merchant.util.Console;

public class QuestionNote extends Note {

    private static final String IS = "is";
    private static final String QUESTION_MARK = " ?";
    private static final String SPLITTER = "\\s+";
    public static final String SIMPLE_QUESTION_IDENTIFIER = "much";

    private final Calculator calculator;
    private final Console console;

    public QuestionNote(String text, Calculator calculator, Console console) {
        super(text);
        this.calculator = calculator;
        this.console = console;
    }

    @Override
    public void process() {
        GalaxyNumber galaxyNumber;
        String number = text.substring(text.indexOf(IS) + 3, text.indexOf(QUESTION_MARK));
        if(text.contains(SIMPLE_QUESTION_IDENTIFIER)) {
            galaxyNumber = calculator.calculate(number);
        } else {
            String targetUnit = text.split(SPLITTER)[2];
            galaxyNumber = calculator.calculate(number, targetUnit);
        }

        console.print(galaxyNumber.toString());
    }
}
