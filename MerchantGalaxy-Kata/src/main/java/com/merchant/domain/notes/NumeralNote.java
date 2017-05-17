package com.merchant.domain.notes;

import com.merchant.ConversionTable;

public class NumeralNote extends Note {

    private static final String SPLITTER = " is ";

    private ConversionTable conversion;

    public NumeralNote(String text, ConversionTable conversion) {
        super(text);
        this.conversion = conversion;
    }

    @Override
    public void process() {
        String[] tokens = this.text.split(SPLITTER);
        conversion.addNumber(tokens[0], tokens[1]);
    }
}
