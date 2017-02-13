package outside.in;

import org.junit.Test;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;

public class FrameParserShould {

    @Test
    public void shouldReturnANormalFrame_when_aNormalStringFrameGiven() {
        String frameValue = "12";
        FrameParser frameParser = new FrameParser();

        Frame frame = frameParser.parse(frameValue);

        assertThat((Normal)frame, isA(Normal.class));
    }

    @Test
    public void shouldReturnASpareFrame_when_aSpareStringFrameGiven() {
        String frameValue = "2/";
        FrameParser frameParser = new FrameParser();

        Frame frame = frameParser.parse(frameValue);

        assertThat((Spare)frame, isA(Spare.class));
    }

    @Test
    public void shouldReturnAstrikeFrame_when_aStrikeStringFrameGiven() {
        String frameValue = "X";
        FrameParser frameParser = new FrameParser();

        Frame frame = frameParser.parse(frameValue);

        assertThat((Strike)frame, isA(Strike.class));
    }

    @Test
    public void shouldReturnAnormalFrame_when_theFrameStringContainsAmiss() {
        String frameValue = "-1";
        FrameParser frameParser = new FrameParser();

        Frame frame = frameParser.parse(frameValue);

        assertThat((Normal) frame, isA(Normal.class));
    }
}
