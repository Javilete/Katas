package outside.in;

public class FrameParser {

    private static final String SPARE = "/";
    private static final String STRIKE = "X";
    private static final String MISS = "-";


    public static Frame parse(String frame) {
        if(frame.contains(STRIKE)){
            return new Strike();
        } else if(frame.contains(SPARE)) {
            return new Spare(getScore(frame.substring(0, frame.length() - 1)));
        } else {
            return new Normal(getScore(frame.substring(0, frame.length() - 1)),
                    getScore(frame.substring(1, frame.length())));
        }
    }

    private static int getScore(String digit) {
        if(MISS.equals(digit)){
            return 0;
        }
        return Integer.parseInt(digit);
    }
}
