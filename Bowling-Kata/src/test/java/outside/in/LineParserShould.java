package outside.in;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LineParserShould {

    @Mock
    private FrameParser frameParser;

    @Test
    public void shouldReturnAgameFullOfSpareFrames() {
        String line = "5/5/5/5/5/5/5/5/5/5/";
        LineParser lineParser = new LineParser(frameParser);

        Game game = lineParser.parse(line);

        assertTrue(game.allFrames().size() == 10);
    }

    @Test
    public void shouldReturnAgameFullOfStrikeFrames() {
        String line = "XXXXXXXXXXXX";
        LineParser lineParser = new LineParser(frameParser);

        Game game = lineParser.parse(line);

        assertTrue(game.allFrames().size() == 12);
    }

    @Test
    public void shouldReturnAgameFullOfNormalFrames() {
        String line = "9-9-9-9-9-9-9-9-9-9-";
        LineParser lineParser = new LineParser(frameParser);

        Game game = lineParser.parse(line);

        assertTrue(game.allFrames().size() == 10);
    }
}
