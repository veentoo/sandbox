package org.veentoo.puzzles;

import org.junit.Test;

public class TestFizzBuzz {

    @Test
    public void testFizzBuzz() {
        FizzBuzz.fizzBuzzLadder();
    }

    @Test
    public void fizzBuzzConcatenation() {
        FizzBuzz.fizzBuzzConcatenation();
    }

    @Test
    public void fizzBuzzArraysLambdaTest() {
        FizzBuzz.fizzBuzzArrayLambda();
    }
}
