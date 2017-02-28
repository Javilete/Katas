package outside.in.game;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AcceptanceTest {

    private Game game;
    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        fizzBuzz = new FizzBuzz(game);
    }

    @Test
    public void shouldReturnTheSameNumber_when_AnormalNumberIsGiven() {
        int inputNumber = 1;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("1"));
    }

    @Test
    public void shouldReturnFizz_when_AmultipleOfThreeIsGiven() {
        int inputNumber = 3;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("fizz"));
    }

    @Test
    public void shouldReturnBuzz_when_AmultipleOfFiveIsGiven() {
        int inputNumber = 5;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("buzz"));
    }

    @Test
    public void shouldReturnFizzBuzz_when_AmultipleOfThreeAndFiveIsGiven() {
        int inputNumber = 15;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("fizz buzz"));
    }

    @Test
    public void shouldReturnPop_when_AmultipleOfSevenIsGiven() {
        int inputNumber = 7;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("pop"));
    }

    @Test
    public void shouldReturnFizzPop_when_AmultipleOfThreeAndSevenIsGiven() {
        int inputNumber = 21;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("fizz pop"));
    }

    @Test
    public void shouldReturnBuzzPop_when_AmultipleOfFiveAndSevenIsGiven() {
        int inputNumber = 35;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("buzz pop"));
    }

    @Test
    public void shouldReturnFizzBuzzPop_when_AmultipleOfThreeFiveAndSevenIsGiven() {
        int inputNumber = 105;

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("fizz buzz pop"));
    }

    @Test
    public void shouldReturnValue_when_aSubtitutionAddedAndAnumberGiven() {
        int inputNumber = 2;
        Game game = new Game();
        FizzBuzz fizzBuzz = new FizzBuzz(game);
        game.addRule(2, "fuzz");

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result, is("fuzz"));
    }

    @Test
    public void shouldReturnCorrectValue_when_severalSustitutionsAddedAndNumbersAreGiven() {
        int inputNumber = 12;
        Game game = new Game();
        FizzBuzz fizzBuzz = new FizzBuzz(game);
        game.addRule(2, "fuzz");
        game.addRule(3, "bizz");

        String result = fizzBuzz.calculateScore(inputNumber);

        assertThat(result , is("fuzz bizz"));
    }
}
