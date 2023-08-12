package com.chivalry.java.basic.paiza;

public class Main {
    public static void main(String[] args) {
        String input = "level";
        System.out.println(isPalindrome(input));
    }
    public static boolean isPalindrome(String sequence) {
        if (sequence == null) {
            return false;
        }

        int left = 0;
        int right = sequence.length() - 1;

        while (left < right) {
            if (sequence.charAt(left) != sequence.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}




