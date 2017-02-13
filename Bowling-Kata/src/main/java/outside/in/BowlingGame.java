package outside.in;

public class BowlingGame {

    private final LineParser lineParser;

    public BowlingGame(LineParser lineParser) {
        this.lineParser = lineParser;
    }

    public int getScore(String line) {
        Game game = lineParser.parse(line);
        return game.score();
    }

}
