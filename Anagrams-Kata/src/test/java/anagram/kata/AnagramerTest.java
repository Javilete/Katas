package anagram.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AnagramerTest {

    @Test
    public void should_returnEmptyList_whenProvidedListEmpty() throws Exception {
        Anagramer anagramer = new Anagramer();
        assertTrue(anagramer.findGroups(Collections.EMPTY_LIST).isEmpty());
    }

    @Test
    public void should_returnSameList_when_thereAreNotAnagrams() throws Exception {
        Anagramer anagramer = new Anagramer();
        List<String> list = Arrays.asList("listen", "hello", "world");

        List<List<String>> result = anagramer.findGroups(list);

        assertThat(list.size(), is(result.size()));
    }

    @Test
    public void should_returnListOfAnagrams_when_thereAreAnagrams() throws Exception {
        Anagramer anagramer = new Anagramer();
        List<String> list = Arrays.asList("listen", "hello", "world", "silent");

        List<List<String>> result = anagramer.findGroups(list);

        assertThat(3, is(result.size()));
    }
}
