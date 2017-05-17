package com.merchant.util;

import com.merchant.ConversionTable;
import com.merchant.domain.notes.Note;
import com.merchant.domain.notes.NumeralNote;
import com.merchant.domain.notes.QuestionNote;
import com.merchant.domain.notes.UnitNote;
import com.merchant.domain.notes.UnknownNote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Parser {

    private static final Pattern NUMERAL_NOTE_PATTERN = Pattern.compile("[a-z\\s]*[A-Z]");
    private static final Pattern UNIT_NOTE_PATTERN =
            Pattern.compile("[a-zA-Z\\s]*\\d*[A-Za-z\\s]*");
    private static final Pattern QUESTION_NOTE_PATTERN =
            Pattern.compile("[a-zA-Z\\s]*is[a-zA-Z\\s]*\\?");

    private ConversionTable conversion;
    private RomanConverter converter;
    private Calculator calculator;
    private Console console;

    private Parser(ConversionTable conversion, RomanConverter converter, Calculator calculator, Console console) {
        this.conversion = conversion;
        this.converter = converter;
        this.calculator = calculator;
        this.console = console;
    }

    public List<Note> parse(String notes) {
        try (Stream<String> stream = Files.lines(Paths.get(notes))) {

            return stream.map(this::createNote)
                    .collect(toList());

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Note createNote(String note) {
        if(NUMERAL_NOTE_PATTERN.matcher(note).matches()) {
            return new NumeralNote(note, conversion);
        } else if(UNIT_NOTE_PATTERN.matcher(note).matches()) {
            return new UnitNote(note, conversion, converter);
        } else if(QUESTION_NOTE_PATTERN.matcher(note).matches()) {
            return new QuestionNote(note, calculator, console);
        }

        return new UnknownNote(note, console);
    }

    public static class Builder {
        private ConversionTable conversion;
        private RomanConverter converter;
        private Calculator calculator;
        private Console console;

        public Builder withConversionTable(ConversionTable conversion) {
            this.conversion = conversion;
            return this;
        }

        public Builder withRomanConverter(RomanConverter converter) {
            this.converter = converter;
            return this;
        }

        public Builder withCalculator(Calculator calculator) {
            this.calculator = calculator;
            return this;
        }

        public Builder withConsole(Console console) {
            this.console = console;
            return this;
        }

        public Parser build() {
            return new Parser(this.conversion, this.converter, this.calculator, this.console);
        }

    }
}
