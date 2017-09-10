package com.brackets;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancerShould {

    private Balancer balancer;

    @Before
    public void setUp() throws Exception {
        balancer = new Balancer();
    }

    @Test
    public void returnYesWhenTheEntryIsBalanced() {
        String entry = "{{[[(())]]}}";

        boolean result = balancer.isBalanced(entry);

        assertTrue(result);
    }

    @Test
    public void returnNoWhenTheEntryIsNotBalanced() {
        String entry = "{[(])}";

        boolean result = balancer.isBalanced(entry);

        assertFalse(result);
    }

    @Test
    public void returnNoWhenThereIsUnknownCharacters() {
        String entry = "{8()8}";

        boolean result = balancer.isBalanced(entry);

        assertFalse(result);
    }

    @Test
    public void returnNoWhenTheOnlyCloseBrackets() {
        String entry = ")]}";

        boolean result = balancer.isBalanced(entry);

        assertFalse(result);
    }
}
