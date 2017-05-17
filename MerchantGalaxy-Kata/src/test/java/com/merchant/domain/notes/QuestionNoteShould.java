package com.merchant.domain.notes;

import com.merchant.domain.GalaxyNumber;
import com.merchant.util.Calculator;
import com.merchant.util.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionNoteShould {

    private QuestionNote question;

    @Mock
    Calculator calculator;

    @Mock
    Console console;

    @Test
    public void callCalculatorWithGalaxyanNumbers() {
        String text = "how much is pish tegj glob glob ?";
        question = new QuestionNote(text, calculator, console);
        when(calculator.calculate(eq("pish tegj glob glob")))
                .thenReturn(new GalaxyNumber("pish tegj glob glob", 42, Optional.empty()));

        question.process();

        verify(calculator).calculate(eq("pish tegj glob glob"));
    }

    @Test
    public void callConsoleWithTheTextToPrintWithoutUnit() {
        String text = "how much is pish tegj glob glob ?";
        question = new QuestionNote(text, calculator, console);
        when(calculator.calculate("pish tegj glob glob")).thenReturn(
                new GalaxyNumber("pish tegj glob glob", 42, Optional.empty()));

        question.process();

        verify(console).print(eq("pish tegj glob glob is 42"));
    }

    @Test
    public void callCalculatorWithGalaxyanNumberAndUnit() {
        String text = "how many Silver is glob Gold ?";
        question = new QuestionNote(text, calculator, console);
        when(calculator.calculate(eq("glob Gold"), eq("Silver")))
                .thenReturn(new GalaxyNumber("glob Gold", 850, Optional.of("Silver")));

        question.process();

        verify(calculator).calculate(eq("glob Gold"), eq("Silver"));
    }

    @Test
    public void callConsoleWithTheTextToPrintWithUnit() {
        String text = "how many Silver is glob Gold ?";
        question = new QuestionNote(text, calculator, console);
        when(calculator.calculate(eq("glob Gold"), eq("Silver")))
                .thenReturn(new GalaxyNumber("glob Gold", 850, Optional.of("Silver")));

        question.process();

        verify(console).print(eq("glob Gold is 850 Silver"));

    }
}
