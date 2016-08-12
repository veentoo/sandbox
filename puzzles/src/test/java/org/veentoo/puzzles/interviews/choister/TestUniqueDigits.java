package org.veentoo.puzzles.interviews.choister;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class TestUniqueDigits {

    @Test
    public void sortDigitsTest() {
        String sorted = Arrays.toString(new UniqueDigits().sortDigits("746312357"));
        assertEquals("Not sorted as expected", "[1, 2, 3, 3, 4, 5, 6, 7, 7]", sorted);
    }

}
