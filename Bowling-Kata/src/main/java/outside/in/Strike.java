package outside.in;

public class Strike implements Frame {

    public static final int POINTS = 10;

    @Override
    public int getPoints() {
        return POINTS;
    }

    @Override
    public int caculateExtraPoints() {
        return POINTS;
    }

    @Override
    public int duplicateScoreBy() {
        return 2;
    }
}
