package anagram.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Anagramer {

    public List<List<String>> findGroups(List<String> list) {

        if(list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Map<String,List<String>> map = list.stream().collect(groupingBy(w -> {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));

        return map.values().stream().collect(toList());
    }
}
