package outside.in.arabic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArabicConversion {

    private Map<String,Integer> conversions = new HashMap<>();

    public ArabicConversion() {
        conversions.put("I", 1);
        conversions.put("V", 5);
        conversions.put("X", 10);
        conversions.put("L", 50);
        conversions.put("C", 100);
        conversions.put("D", 500);
        conversions.put("M", 1000);
    }

    public Map<String, Integer> getTable() {
        return Collections.unmodifiableMap(conversions);
    }
}
