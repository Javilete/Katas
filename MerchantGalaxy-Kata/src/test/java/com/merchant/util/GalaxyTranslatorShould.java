package com.merchant.util;

import com.merchant.domain.notes.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GalaxyTranslatorShould {

    private GalaxyTranslator translator;

    @Mock
    Note note;

    @Mock
    Parser parser;

    @Before
    public void setUp() throws Exception {
        translator = new GalaxyTranslator(parser);
    }

    @Test
    public void callParserWithTheInput() {
        String notes = "glob is I\n" +
                "prok is V\n" +
                "pish is X\n" +
                "tegj is L\n";

        translator.read(notes);

        verify(parser).parse(notes);
    }

    @Test
    public void callProcessMethodPerLine() {
        String notes = "glob is I\n" +
                "glob glob Silver is 34 Credits\n";
        when(parser.parse(eq(notes))).thenReturn(Arrays.asList(note));

        translator.read(notes);

        verify(note).process();
    }
}
