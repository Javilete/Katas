package com.merchant.domain.notes;

public abstract class Note {

    protected String text;

    public Note(String text) {
        this.text = text;
    }

    public abstract void process();
}
