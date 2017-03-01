package outside.in.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameShould {

    @Test
    public void shouldAddAnewConditionToTheRuleSet() {
        Integer subtitution = 2;
        String value = "fuzz";
        Game rule = new Game();

        rule.addRule(subtitution, value);

        assertThat(rule.getRules().get(subtitution), is(value));
    }

    @Test
    public void shouldReplaceAnExistingConditionToTheRuleSet() {
        Integer substitution = 3;
        String value = "fuzz";
        Game rule = new Game();

        rule.addRule(substitution, value);

        assertThat(rule.getRules().get(substitution), is("fuzz"));
    }
}
