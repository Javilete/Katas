package outside.in.game;

import java.util.LinkedHashMap;
import java.util.Map;

public class Game {

    private static final String FIZZ_VALUE = "fizz";
    private static final String BUZZ_VALUE = "buzz";
    private static final String POP_VALUE = "pop";

    private final  Map<Integer,String> rules = new LinkedHashMap<>();

    public Game() {
        rules.put(3, FIZZ_VALUE);
        rules.put(5, BUZZ_VALUE);
        rules.put(7, POP_VALUE);
    }

    public void addRule(Integer condition, String value) {
        rules.put(condition, value);
    }

    public Map<Integer,String> getRules() {
        return rules;
    }
}
