package outside.in;

public class LineParser {

    private static final String SINGLE_FRAME = "X";

    private final FrameParser frameParser;
    private int parsingIndex;

    public LineParser(FrameParser frameParser) {
        this.frameParser = frameParser;
    }

    public Game parse(String line) {
        Game game = new Game();
        Frame frame;

        for(parsingIndex = 0; parsingIndex < line.length(); parsingIndex++ ) {
            if(isSingleFrame(line.substring(parsingIndex, parsingIndex + 1))){
                frame = frameParser.parse(line.substring(parsingIndex, parsingIndex + 1));
            } else {
                frame = frameParser.parse(line.substring(parsingIndex, parsingIndex + 2));
                parsingIndex++;
            }
            game.addFrame(frame);
        }

        return game;
    }

    private boolean isSingleFrame(String line) {
        return SINGLE_FRAME.equals(line);
    }
}
