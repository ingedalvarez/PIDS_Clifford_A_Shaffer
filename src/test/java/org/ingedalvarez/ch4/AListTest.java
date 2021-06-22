package org.ingedalvarez.ch4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AListTest {

    List<String> list;

    @Before
    public void setUp() throws Exception {
        list = new AList<String>(5);
        list.append("A");
        list.append("E");
        list.append("I");
        list.append("O");
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void clear() {
        assertNotNull(list);
        assertEquals(4, list.length());
        assertEquals(0, list.currPos());
        list.next();
        assertEquals(1, list.currPos());
        list.clear();
        assertEquals(0, list.length());
        assertEquals(0, list.currPos());

    }

    @Test(expected = AssertionError.class)
    public void insert() {
        list.insert("U");
        assertEquals("U", list.getValue());
        list.moveToPos(1);
        assertEquals("A", list.getValue());
        assertEquals(5, list.length());
        list.insert("U"); //Arroja error porque excede la capacidad de la AList.
    }

    @Test
    public void append() {
        assertEquals(4, list.length());
        list.append("U");
        assertEquals(0, list.currPos());
        assertEquals("A", list.getValue());
        assertEquals(5, list.length());
        list.moveToPos(4);
        assertEquals("U", list.getValue());

    }

    @Test
    public void remove() {
        assertEquals("A", list.remove());
        assertEquals(3, list.length());
        list.moveToPos(2);
        assertEquals("O", list.getValue());
    }

    @Test
    public void moveToStart() {
        list.moveToPos(3);
        assertEquals(3, list.currPos());
        list.moveToStart();
        assertEquals(0, list.currPos());
    }

    @Test
    public void moveToEnd() {
        assertEquals(0, list.currPos());
        list.moveToEnd();
        assertEquals(4, list.currPos());
    }

    @Test
    public void prev() {
        list.prev();
        list.moveToPos(2);
        assertEquals(2, list.currPos());
        list.prev();
        assertEquals(1, list.currPos());
    }

    @Test
    public void next() {
        list.next();
        assertEquals(1, list.currPos());
        list.moveToPos(3);
        list.next();
        assertEquals(4, list.currPos());
        list.next();
        assertEquals(4, list.currPos());
    }

    @Test
    public void length() {
        assertEquals(4, list.length());
        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    public void currPos() {
        assertEquals(0, list.currPos());
    }

    @Test(expected = AssertionError.class)
    public void moveToPos() {
        list.moveToPos(5);
        list.moveToPos(4);
        assertEquals(4, list.currPos());
    }

    @Test
    public void getValue() {
        assertEquals("A", list.getValue());
    }
}