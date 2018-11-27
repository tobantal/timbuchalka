package com.timbuchalka.Utilities;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;

public class UtilitiesTest {

    private Utilities util;

    @Before
    public void setUp() {
        util = new Utilities();
    }

    @Test
    public void everyNthChar() throws Exception {
        Utilities utils = new Utilities();
        char[] output = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] { 'e', 'l'}, output);
        char[] output2 = utils.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() throws Exception {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Arguments passed", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @Test
    public void converter() throws Exception {
        assertEquals(300, util.converter(10, 5));
    }

    @Test(expected=ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
        util.converter(10, 0);

    }

    @Test
    public void nullIfOddLength() throws Exception {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }

}