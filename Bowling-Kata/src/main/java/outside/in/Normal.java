package outside.in;

public class Normal implements Frame{

    private final int roll1;
    private final int roll2;

    public Normal(int roll1, int roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    @Override
    public int getPoints() {
        return this.roll1 + this.roll2;
    }

    @Override
    public int caculateExtraPoints() {
        return 0;
    }

    @Override
    public int duplicateScoreBy() {
        return 0;
    }
}
