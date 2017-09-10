package com.brackets;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String DELIMITER = "\n";

    public List<String> split(String entry) {
        String[] parts =  entry.split(DELIMITER);

        return Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
    }
}
