package org.veentoo.puzzles.interviews.choister;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUniqueDigits {

    @Before
    public void prepareClass() throws NoSuchMethodException {

    }

    @Test
    public void findDuplicatesTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method findDuplicatesMethod = UniqueDigits.class.getDeclaredMethod("findDuplicates", String.class);
        findDuplicatesMethod.setAccessible(true);
        int pos = ((Integer) findDuplicatesMethod.invoke(null, "1001"));
        assertEquals("Not equal", 3, pos);
        System.out.println(Integer.MAX_VALUE);
    }
}
