package com.fizzbuzz;

public class Sum {

    public static int sum(int x, int y) {
        if(isInvalid(x) || (isInvalid(y))) {
            throw new RuntimeException();
        }

        return x + y;
    }

    private static boolean isInvalid(int number) {
        return number < 0 || number > 100;
    }

}
