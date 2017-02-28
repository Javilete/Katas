package outside.in.game;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FizzBuzz {

    private final Game game;

    public FizzBuzz(Game game) {
        this.game = game;
    }

    public String calculateScore(int number) {
        Map<Integer, String> rules = game.getRules();

        String score = rules.keySet().stream()
                .filter(i -> number % i == 0)
                .sorted()
                .map(rules::get)
                .collect(Collectors.joining(" "));

        if(score.isEmpty()) {
            return String.valueOf(number);
        }

        return score;
    }
}
