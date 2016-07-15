package org.veentoo.puzzles.palindromes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestPalindrome {

    @Test
    public void isPalindromeUsingFlipTest() {
        for (String palindrome : palindromes) {
            assertTrue(Palindrome.isPalindromeUsingFlip(palindrome));
        }
        for (String nonPalindrome : nonPalindromes) {
            assertFalse(Palindrome.isPalindromeUsingFlip(nonPalindrome));
        }
    }

    @Test
    public void isPalindromeMemoryEfficientTest() {
        for (String palindrome : palindromes) {
            assertTrue(Palindrome.isPalindromeMemoryEfficient(palindrome));
        }
        for (String nonPalindrome : nonPalindromes) {
            assertFalse(Palindrome.isPalindromeMemoryEfficient(nonPalindrome));
        }
    }

    private static final List<String> palindromes = new ArrayList<String>() {
        {
            add("Madam, I'm Adam");
            add("Argentina manit negra");
            add("707-121-707");
            add("112211");
        }
    };

    private static final List<String> nonPalindromes = new ArrayList<String>() {
        {
            add("Madam, I'm Adams");
            add("Argentina manit negrov");
            add("707-123-707");
            add("112311");
        }
    };
}
