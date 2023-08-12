package com.chivalry.java.basic.paiza;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(test(3));
    }

    public static int test(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int prev1 = 1, prev2 = 1, fib = 0;

        for (int i = 3; i <= n; i++) {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
        }
        return fib;
    }
}
