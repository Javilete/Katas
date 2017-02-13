package outside.in;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GuidingTest {

    private FrameParser frameParser;
    private LineParser lineparser;
    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        frameParser = new FrameParser();
        lineparser = new LineParser(frameParser);
        bowlingGame = new BowlingGame(lineparser);
    }

    @Test
    public void givenAbowlingLineWithOnlySpares_shouldReturnTheScore() {
        String bowlingLine = "5/6/5/5/5/5/5/5/5/7/";

        int score = bowlingGame.getScore(bowlingLine);

        assertThat(153, is(score));
    }

    @Test
    public void givenAbowlingLineWithOnlyStrikes_shouldReturnTheScore() {
        String bowlingLine = "XXXXXXXXXXXX";

        int score = bowlingGame.getScore(bowlingLine);

        assertThat(300, is(score));
    }

    @Test
    public void givenAbowlingLineWithTenPairsOf9AndMiss_shouldReturnTheScore() {
        String bowlingLine = "9-9-9-9-9-9-9-9-9-9-";

        int score = bowlingGame.getScore(bowlingLine);

        assertThat(90, is(score));
    }
}
