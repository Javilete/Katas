package com.merchant.domain.notes;

import com.merchant.util.Console;

public class UnknownNote extends Note {

    private static final String DEFAULT_MESSAGE = "I have no idea what you are talking about";

    private final Console console;

    public UnknownNote(String text, Console console) {
        super(text);
        this.console = console;
    }

    @Override
    public void process() {
        console.print(DEFAULT_MESSAGE);
    }
}
