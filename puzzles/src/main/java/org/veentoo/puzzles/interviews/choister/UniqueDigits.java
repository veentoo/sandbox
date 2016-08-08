package org.veentoo.puzzles.interviews.choister;

import java.util.Arrays;

/**
 * @author Anatoly Semenov
 *         Date: 18.07.2016
 *
 * Реализовать поиск чисел в указанном диапазоне , в которых нет повторяющихся цифр.
 * Пр-р для диапазона (97, 103) результат будет [97, 98, 102].
 * Алгоритм должен за обозримое время обрабатывать диапазон 0..2^31(Integer.MAX_VALUE)
 */
public class UniqueDigits {
    public static void main(final String... args) {
        assertEquals(new int[] {1}, getNumbers(1, 2));
        assertEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, getNumbers(0, 10));
        assertEquals(new int[] {97, 98, 102}, getNumbers(97, 103));

        long start = System.currentTimeMillis();
        assertEquals(6028171, getNumbers(0, Integer.MAX_VALUE).length);
        long finish = System.currentTimeMillis();
        long time = (finish - start) / 1000;
        System.out.println("time of [0, MAX_VALUE) is " + time + " s");
    }

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

    private static int findDuplicates(String n) {
        for (int i = 0; i < n.length(); i++) {
            for (int j = n.length() - 1; j > i; j--) {
                if (n.charAt(i) == n.charAt(j)) {
                    return j;
                }
            }
        }
        return 0;
    }

}