package com.brackets;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private Splitter splitter;
    private Balancer balancer;

    public Calculator(Splitter splitter, Balancer balancer) {
        this.splitter = splitter;
        this.balancer = balancer;
    }

    public String calculateOutput(String input) {
        List<String> entries =  splitter.split(input);

        return entries.stream()
                .map(e -> balancer.isBalanced(e) ? "YES" : "NO")
                .collect(Collectors.joining("\n"));
    }
}
