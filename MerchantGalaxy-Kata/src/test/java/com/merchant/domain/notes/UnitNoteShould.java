package com.merchant.domain.notes;

import com.merchant.ConversionTable;
import com.merchant.domain.Unit;
import com.merchant.util.RomanConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnitNoteShould {

    private UnitNote unitInput;

    @Mock
    ConversionTable conversion;

    @Mock
    RomanConverter converter;

    @Test
    public void callAddNumberToConversionTable() {
        unitInput = new UnitNote("glob glob Silver is 34 Credits", conversion, converter);
        Unit unit = new Unit(17.0, "Silver");
        Map<String, String> numbers = new HashMap<>();
        numbers.put("glob", "I");
        when(converter.convert(eq("II"))).thenReturn(2);
        when(conversion.getNumbers()).thenReturn(numbers);

        unitInput.process();

        verify(conversion).addUnit(eq("Silver"), eq(unit));
    }
}
