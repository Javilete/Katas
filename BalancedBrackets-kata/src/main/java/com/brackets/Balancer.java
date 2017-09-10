package com.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Balancer {

    private static final String EXPRESSION = "^[\\(\\)\\[\\]{}]*$";

    private Map<Character, String> pair = new HashMap<>();
    private Pattern pattern = Pattern.compile(EXPRESSION);

    public Balancer() {
        pair.put('{', "}");
        pair.put('(', ")");
        pair.put('[', "]");
    }

    public boolean isBalanced(String entry) {
        boolean result = false;

        if (pattern.matcher(entry).find()) {
            for (int i = 0; i < entry.length() / 2; i++) {
                String closeBracket = pair.get(entry.charAt(i));
                if (String.valueOf(entry.charAt(entry.length() - 1 - i)).equals(closeBracket)) {
                    result = true;
                } else {
                    return false;
                }
            }
        }

        return result;
    }
}
