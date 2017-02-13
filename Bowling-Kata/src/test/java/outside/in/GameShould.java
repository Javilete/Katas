package outside.in;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;

public class GameShould {

    @Test
    public void shouldAddAframe_whenItIsAddedToTheGame() {
        Game game = new Game();
        game.addFrame(new Strike());

        List<Frame> frames = game.allFrames();

        assertThat(frames.size(), is(1));
        assertThat((Strike)frames.get(0), isA(Strike.class));
    }

    @Test
    public void shouldCalculateTheScore_whenAgameIsGivenWithAllStrikes() {
        Game game = new Game();
        for(int i = 0; i < 12; i ++) {
            game.addFrame(new Strike());
        }

        int score = game.score();

        assertThat(300, is(score));
    }

    @Test
    public void shouldCalculateTheScore_whenAgameIsGiveWithAllSpares() {
        Game game = new Game();
        for(int i = 0; i < 11; i ++) {
            game.addFrame(new Spare(5));
        }

        int score = game.score();

        assertThat(150, is(score));
    }

}
