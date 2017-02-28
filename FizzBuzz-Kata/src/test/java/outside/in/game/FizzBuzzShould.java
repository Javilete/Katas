package outside.in.game;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzShould {

    @Mock
    private Game game;

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz(game);
    }

    @Test
    public void shouldReturnValueOfEntry_when_calculatingTheScoreThereIsMatchingRule() {
        Map<Integer,String> rules = new LinkedHashMap<>();
        String expectedValue = "value";
        rules.put(2, expectedValue);
        when(game.getRules()).thenReturn(rules);

        String value = fizzBuzz.calculateScore(2);

        assertThat(value, is(expectedValue));
    }

    @Test
    public void shouldReturnSameNumber_when_calculatingTheScoreThereIsNoMatchingRule() {
        String expectedValue = "2";
        when(game.getRules()).thenReturn(Collections.EMPTY_MAP);

        String value = fizzBuzz.calculateScore(2);

        assertThat(value, is(expectedValue));
    }
}
