package org.veentoo.puzzles.palindromes;

import org.apache.log4j.Logger;

public class Palindrome {
    private static final Logger log = Logger.getLogger(Palindrome.class);

    public static boolean isPalindromeUsingFlip(String input) {
        if (!validateInput(input)) return false;
        if (input.length() == 1) {
            return true;
        }
        String preparedInput = prepareInput(input);

        char[] flipped = new char[preparedInput.length()];
        int i = preparedInput.length() - 1;
        for (char c : preparedInput.toCharArray()) {
            flipped[i] = c;
            i--;
        }
        return new String(flipped).equals(preparedInput);
    }

    public static boolean isPalindromeMemoryEfficient(String input) {
        if (!validateInput(input)) return false;
        if (input.length() == 1) {
            return true;
        }
        String preparedInput = prepareInput(input);

        for (int i = 0, j = preparedInput.length() - 1; i < j; i++, j--) {
            if (preparedInput.charAt(i) != preparedInput.charAt(j)) {
                log.debug("Discrepancy at chars (" + i + ", " + j + ") = (" + preparedInput.charAt(i) + ", " + preparedInput.charAt(j) + ")");
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeUsingLambda(String input) {
        if (!validateInput(input)) return false;
        String preparedInput = prepareInput(input);
        return false;
    }

    private static boolean validateInput(String input) {
        return !(input == null || input.length() == 0);
    }

    private static String prepareInput(String input) {
        String replacedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        log.debug("replacedInput: " + replacedInput);
        return replacedInput;
    }

}
