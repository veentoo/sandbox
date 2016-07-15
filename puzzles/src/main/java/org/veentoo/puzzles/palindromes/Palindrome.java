package org.veentoo.puzzles.palindromes;


import org.apache.log4j.Logger;

public class Palindrome {
    private static final Logger log = Logger.getLogger(Palindrome.class);

    public static boolean isPalindromeUsingFlip(String input) {
        String replacedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        log.debug("replacedInput: " + replacedInput);

        char[] flipped = new char[replacedInput.length()];
        int i = replacedInput.length() - 1;
        for (char c : replacedInput.toCharArray()) {
            flipped[i] = c;
            i--;
        }
        return new String(flipped).equals(replacedInput);
    }

    public static boolean isPalindromeMemoryEfficient(String input) {
        return false;
    }
}
