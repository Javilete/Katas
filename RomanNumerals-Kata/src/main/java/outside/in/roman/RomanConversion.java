package outside.in.roman;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanConversion {

    private Map<Integer, String> conversions = new HashMap<>();

    public RomanConversion() {
        conversions.put(1, "I");
        conversions.put(4, "IV");
        conversions.put(5, "V");
        conversions.put(9, "IX");
        conversions.put(10, "X");
        conversions.put(40, "XL");
        conversions.put(50, "L");
        conversions.put(90, "XC");
        conversions.put(100, "C");
        conversions.put(400, "CD");
        conversions.put(500, "D");
        conversions.put(900, "CM");
        conversions.put(1000, "M");
    }

    public Map<Integer, String> getTable() {
        return Collections.unmodifiableMap(conversions);
    }
}
