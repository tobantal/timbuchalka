package com.timbuchalka.problems;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        String[] str = String.valueOf(Math.abs(number)).split("");
        int n = str.length / 2;
        int k = n - 1;
        while (k >= 0) {
            if (!str[k].equals(str[str.length - 1 - k])) {
                return false;
            }
            k--;
        }
        return true;
    }
}