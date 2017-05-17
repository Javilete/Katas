package com.merchant.domain.notes;

import com.merchant.util.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UnknownNoteShould {

    private UnknownNote unknownInput;

    @Mock
    private Console console;

    @Test
    public void callConsoleWithDefaulteMessage() {
        unknownInput = new UnknownNote("how much wood could a woodchuck chuck " +
                "if a woodchuck could chuck wood ?", console);

        unknownInput.process();

        verify(console).print(eq("I have no idea what you are talking about"));
    }
}
