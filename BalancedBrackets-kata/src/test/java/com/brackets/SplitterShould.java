package com.brackets;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitterShould {

    private Splitter splitter;

    @Before
    public void setUp() throws Exception {
        splitter = new Splitter();
    }

    @Test
    public void shouldReturnListOfEntriesFromAnInput() {
        String input = "3\n" +
                "{[()]}\n" +
                "{[(])}\n" +
                "{{[[(())]]}}";

        List<String> result = splitter.split(input);

        assertThat(result.size(), is(3));
    }
}
