package outside.in;

public class Spare implements Frame {

    public static final int POINTS = 10;
    private final int roll1;

    public Spare(int roll1) {
        this.roll1 = roll1;
    }

    @Override
    public int getPoints() {
        return POINTS;
    }

    @Override
    public int caculateExtraPoints() {
        return this.roll1;
    }

    @Override
    public int duplicateScoreBy() {
        return 1;
    }
}
