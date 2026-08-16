package com.rrachet.dsaforge.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmsTest {
    @Test void palindromeIgnoresPunctuationAndCase() {
        assertTrue(ValidPalindrome.check("A man, a plan, a canal: Panama"));
        assertFalse(ValidPalindrome.check("race a car"));
        assertTrue(ValidPalindrome.check(""));
    }
}
