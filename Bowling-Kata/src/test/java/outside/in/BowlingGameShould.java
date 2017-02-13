package outside.in;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BowlingGameShould {

    @Mock
    private LineParser lineparser;

    @Mock
    private Game game;

    @Test
    public void shouldCallScoreFromGame_whenLineHasBeenParsed() {
        String line = "5/5/5/5/5/5/5/5/5/5/5";
        BowlingGame bowlingGame = new BowlingGame(lineparser);
        when(lineparser.parse(line)).thenReturn(game);

        bowlingGame.getScore(line);

        verify(game).score();
    }
}
