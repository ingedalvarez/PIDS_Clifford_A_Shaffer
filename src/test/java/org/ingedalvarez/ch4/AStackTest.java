package org.ingedalvarez.ch4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AStackTest {

    AStack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new AStack<>();
        stack.push("A");
    }

    @Test
    public void clear() {
        assertEquals(1, stack.length());
        stack.clear();
        assertEquals(0, stack.length());
    }

    @Test
    public void push() {
        assertEquals(1, stack.length());
        stack.push("E");
        assertEquals(2, stack.length());
    }

    @Test
    public void pop() {
        stack.pop();
        assertEquals(0, stack.length());
    }

    @Test
    public void topValue() {
        assertEquals("A", stack.topValue());
        stack.push("E");
        assertEquals("E", stack.topValue());

    }

    @Test
    public void length() {
        assertEquals(1, stack.length());
    }
}