package com.timbuchalka.problems;

import org.junit.Test;

import static com.timbuchalka.problems.NumberPalindrome.isPalindrome;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NumberPalindromeTest {

    @Test
    public void isPalindromeTest() {
        assertTrue(isPalindrome(12321));
        assertTrue(isPalindrome(472101274));
        assertFalse(isPalindrome(346468789));
    }
}