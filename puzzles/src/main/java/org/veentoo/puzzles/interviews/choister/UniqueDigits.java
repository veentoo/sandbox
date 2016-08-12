package org.veentoo.puzzles.interviews.choister;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Anatoly Semenov
 *         Date: 18.07.2016
 */
public class UniqueDigits {

    private static void assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new AssertionError("expected ='" + expected + "'" + " but was '" + actual + "'");
    }

    private static void assertEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual))
            throw new AssertionError("expected ='" + Arrays.toString(expected) + "'" + " but was '" +
                    Arrays.toString(actual) + "'");
    }

    private static void assertLessOrEquals(int max, int actual) {
        if (actual > max) {
            throw new AssertionError("max expected ='" + max + "'" + " but was '" + actual + "'");
        }
    }

    public static int[] getNumbers(int startInclusive, int endExclusive) {

        return new int[0];
    }

    public Integer findSkipDigitPosition (String n) {
        List<Integer> duplicates = findDuplicates(n);
        if (duplicates.size() == 0) {
            return -1;
        }
        Integer minLastPosition = n.length();
        for (Integer duplicate : duplicates) {
            int position = n.lastIndexOf(duplicate.toString());
            if (position < minLastPosition) {
                minLastPosition = position;
            }
        }
        return minLastPosition;
    }

    public List<Integer> findDuplicates(String n) {
        List<Integer> duplicates = new ArrayList<>();
        Integer[] sortedDigits = sortDigits(n);
        Integer prevDigit = null;
        for (int i = 0; i < sortedDigits.length; i++) {
            Integer sortedDigit = sortedDigits[i];
            if (prevDigit == null || sortedDigit != prevDigit) {
                prevDigit = sortedDigit;
            } else {
                duplicates.add(sortedDigit);
            }
        }
        return duplicates;
    }

    public Integer[] sortDigits(String n) {
        if (n.length() > 2) {
            // split
            String n1 = n.substring(0, n.length() / 2);
            String n2 = n.substring(n.length() / 2);
            Integer[] sorted1 = sortDigits(n1);
            Integer[] sorted2 = sortDigits(n2);
            return mergeDigits(sorted1, sorted2);
        } else if (n.length() == 1) {
            return new Integer[]{Integer.valueOf(n)};
        } else { // n == 2
            List<Integer> digits = new ArrayList<>();
            // split to digits, convert to int
            n.chars().mapToObj(i -> (char) i)
                                    .map(i -> Character.getNumericValue(i)).forEach(i -> digits.add(i));
            Collections.sort(digits, (x, y) -> x - y);
            Integer[] sorted = digits.toArray(new Integer[digits.size()]);
            return sorted;
        }
    }

    public Integer[] mergeDigits(Integer[] arr1, Integer[] arr2) {
        Integer result[] = new Integer[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        if (i < arr1.length) {
            System.arraycopy(arr1, i, result, k, arr1.length - i);
        } else if (j < arr2.length) {
            System.arraycopy(arr2, j, result, k, arr2.length - j);
        }
        return result;
    }

}








//    public static void main(final String... args) {
//        assertEquals(new int[] {1}, getNumbers(1, 2));
//        assertEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, getNumbers(0, 10));
//        assertEquals(new int[] {97, 98, 102}, getNumbers(97, 103));
//
//        long start = System.currentTimeMillis();
//        assertEquals(6028171, getNumbers(0, Integer.MAX_VALUE).length);
//        long finish = System.currentTimeMillis();
//        long time = (finish - start) / 1000;
//        System.out.println("time of [0, MAX_VALUE) is " + time + " s");
//        System.out.println("time of [0, MAX_VALUE) is " + time + " s");
//        System.out.println(new UniqueDigits().sortDigits("7463125"));
//    }
