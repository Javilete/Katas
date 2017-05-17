package com.merchant.util;

import com.merchant.ConversionTable;
import com.merchant.domain.notes.Note;
import com.merchant.domain.notes.NumeralNote;
import com.merchant.domain.notes.QuestionNote;
import com.merchant.domain.notes.UnitNote;
import com.merchant.domain.notes.UnknownNote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ParserShould {

    private Map<String, String> tableNumberConversion = new HashMap<>();

    @Mock
    ConversionTable conversion;

    @Mock
    RomanConverter converter;

    @Mock
    Calculator calculator;

    @Mock
    Console console;

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser.Builder().withConversionTable(conversion)
                .withRomanConverter(converter)
                .withCalculator(calculator)
                .withConsole(console)
                .build();
        tableNumberConversion.put("glob", "I");
        tableNumberConversion.put("prok", "V");
        tableNumberConversion.put("pish", "X");
        tableNumberConversion.put("tegj", "L");
    }

    @Test
    public void returnAlistOfNumeralNote() {
        String notes = "./src/test/resources/numeral_notes.txt";

        List<Note> lines = parser.parse(notes);

        assertTrue(lines.get(0).getClass().equals(NumeralNote.class));
    }

    @Test
    public void returnAlistOfUnitNote() {
        String notes = "./src/test/resources/unit_notes.txt";

        List<Note> lines = parser.parse(notes);

        assertTrue(lines.get(0).getClass().equals(UnitNote.class));
    }

    @Test
    public void returnAlistOfQuestionNote() {
        String notes = "./src/test/resources/question_notes.txt";

        List<Note> lines = parser.parse(notes);

        assertTrue(lines.get(0).getClass().equals(QuestionNote.class));
    }

    @Test
    public void returnAlistOfQuestionNoteAboutMetals() {
        String notes = "./src/test/resources/question_notes_metals.txt";

        List<Note> lines = parser.parse(notes);

        assertTrue(lines.get(0).getClass().equals(QuestionNote.class));
    }

    @Test
    public void returnAlistOfUnknownNote() {
        String notes = "./src/test/resources/unknown_notes.txt";

        List<Note> lines = parser.parse(notes);

        assertTrue(lines.get(0).getClass().equals(UnknownNote.class));
    }
}
