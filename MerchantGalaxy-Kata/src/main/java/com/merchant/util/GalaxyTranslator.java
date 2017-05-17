package com.merchant.util;

import com.merchant.domain.notes.Note;

import java.util.List;

public class GalaxyTranslator {

    private Parser parser;

    public GalaxyTranslator(Parser parser) {
        this.parser = parser;
    }

    public void read(String notes) {
        List<Note> allNotes = parser.parse(notes);
        allNotes.stream()
                .forEach(Note::process);
    }
}
