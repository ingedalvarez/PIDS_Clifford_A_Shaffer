package org.ingedalvarez.ch4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LListTest {
    LList<String> list;
    @Before
    public void setUp() throws Exception {
        list = new LList<>();
        list.insert("A");
        list.insert("E");
        list.insert("I");
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void clear() {
        assertEquals(3, list.length());
    }

    @Test
    public void insert() {
        list.insert("O");
        assertEquals(4, list.length());
        assertEquals("O", list.getValue());
    }

    @Test
    public void append() {
        list.append("O");
        assertEquals(4, list.length());
        assertEquals("I", list.getValue());
    }

    @Test
    public void remove() {
        assertEquals(3, list.length());
        assertEquals("I", list.getValue());
        list.remove();
        assertEquals("E", list.getValue());
        assertEquals(2, list.length());

    }

    @Test
    public void moveToStart() {
        list.moveToStart();
        assertEquals(0, list.currPos());
    }

    @Test
    public void moveToEnd() {
        list.moveToEnd();
        assertEquals(3, list.currPos());
    }

    @Test
    public void prev() {
        list.moveToEnd();
        list.prev();
        assertEquals(2, list.currPos());
        list.prev();
        assertEquals(1, list.currPos());
    }

    @Test
    public void next() {
        list.next();
        assertEquals(1, list.currPos());
        list.next();
        assertEquals(2, list.currPos());
    }

    @Test
    public void length() {
        assertEquals(3, list.length());
    }

    @Test
    public void currPos() {
        assertEquals(0, list.currPos());
        list.moveToEnd();
        assertEquals(3, list.currPos());
    }

    @Test
    public void moveToPos() {
        list.moveToPos(2);
        assertEquals(2, list.currPos());
    }

    @Test
    public void getValue() {
        assertEquals("I", list.getValue());
    }
}