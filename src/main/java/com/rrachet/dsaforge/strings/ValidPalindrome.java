package com.rrachet.dsaforge.strings;

/** Checks alphanumeric palindrome using two pointers. Time O(n), space O(1). */
public final class ValidPalindrome {
    private ValidPalindrome() {}

    public static boolean check(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) right--;
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) return false;
            left++; right--;
        }
        return true;
    }
}
