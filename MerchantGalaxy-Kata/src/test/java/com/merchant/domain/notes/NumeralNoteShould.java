package com.merchant.domain.notes;

import com.merchant.ConversionTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NumeralNoteShould {

    private NumeralNote numeralInput;

    @Mock
    private ConversionTable conversion;

    @Test
    public void callAddNumberToConversionTable() {
        numeralInput = new NumeralNote("glob is I", conversion);

        numeralInput.process();

        verify(conversion).addNumber(eq("glob"), eq("I"));
    }
}
