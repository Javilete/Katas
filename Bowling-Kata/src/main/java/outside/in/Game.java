package outside.in;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int FRAMES_PER_GAME = 10;
    private List<Frame> frames = new ArrayList<>();

    private int score = 0;

    public int score() {
        for(int i = 0; i < FRAMES_PER_GAME; i++) {
            Frame frame = frames.get(i);
            updateScore(frame);
            addPlusToScore(i, frames.get(i));
        }

        return score;
    }

    private void addPlusToScore(int currentFrameIndex, Frame frame) {
        for(int j = 0; j < frame.duplicateScoreBy(); j++) {
            score += frames.get(currentFrameIndex + j).caculateExtraPoints();
        }
    }

    private void updateScore(Frame frame) {
        this.score += frame.getPoints();
    }

    public List<Frame> allFrames() {
        return this.frames;
    }

    public void addFrame(Frame strike) {
        this.frames.add(strike);
    }
}
