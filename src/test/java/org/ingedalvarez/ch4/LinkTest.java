package org.ingedalvarez.ch4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkTest {
    Link<String> tail, link2, link3;
    @Before
    public void setUp() throws Exception {
        tail = new Link<>("A", null);
        link2 = new Link<>("E", null);
        link3 = new Link<>("I", null);
    }

    @After
    public void tearDown() throws Exception {
        tail = link2 = link3 = null;
    }

    @Test
    public void next() {
        assertNull(tail.next());
        assertEquals("A", tail.element());
    }

    @Test
    public void setNext() {
        assertEquals(link2, tail.setNext(link2));
        assertEquals(link2, tail.next());
        assertEquals("E", link2.element());
        assertEquals("A", tail.element());
        tail = link2;
        assertEquals("E", link2.element());
        assertEquals("E", tail.element());
        assertNull(tail.next());

    }

    @Test
    public void setElement() {
    }

    @Test
    public void element() {
    }
}