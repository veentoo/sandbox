package org.veentoo.puzzles;

import java.util.Arrays;

/**
 * See https://www.rosettacode.org/wiki/FizzBuzz/Java
 */
public class FizzBuzz {

    public static void fizzBuzzLadder() {
        for (int i = 0; i <= 100; i++) {
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else
                System.out.println(i);
        }
    }

    public static void fizzBuzzConcatenation() {
        for (int i = 0; i < 100; i++) {
            String out = "";
            if (i % 3 == 0) out += "Fizz";
            if (i % 5 == 0) out += "Buzz";
            if (out.equals("")) out = ""+i;
            System.out.println(out);
        }
    }

    public static void fizzBuzzArrayLambda() {
        int arr[] = new int[100];
        Arrays.setAll(arr, j -> j);
        System.out.println(Arrays.toString(arr));
    }

}
