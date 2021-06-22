package org.ingedalvarez.ch4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LListTest {
    LList<String> list;
    Link<String> node1, node2, node3, node4, node5;

    @Before
    public void setUp() throws Exception {
        list = new LList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void init(){
        assertNotNull(list);
        assertEquals(0, list.length());
        assertEquals(list.head, list.tail);
        assertEquals(list.head, list.curr);

    }

    @Test
    public void clear() {
    }

    @Test
    public void insert() {
        assertNotNull(list);

        assertEquals(0, list.length());
        assertEquals(list.head, list.tail);
        assertEquals(list.tail, list.curr);
        list.insert("A");
        assertEquals(1, list.length());
        assertNotEquals(list.tail, list.curr);
        assertNotEquals(list.tail, list.head);
        assertEquals("A", list.head.next().element());
        assertEquals("A", list.curr.next().element());
        assertEquals("A", list.tail.element());
        list.insert("E");
        assertEquals(2, list.length());
        assertEquals("E", list.head.next().element());
        assertEquals("E", list.curr.next().element());
        assertEquals("A", list.tail.element());
        list.insert("I");
        assertEquals(3, list.length());
        assertEquals("I", list.head.next().element());
        assertEquals("I", list.curr.next().element());
        assertEquals("A", list.tail.element());
        assertNull(list.head.element());
        assertNull(list.curr.element());


    }

    @Test
    public void append() {
        list.append("A");
        assertEquals(1, list.length());
        assertEquals("A", list.head.next().element());
        assertEquals("A", list.curr.next().element());
        assertEquals("A", list.tail.element());
        list.append("E");
        assertEquals(2, list.length());
        assertEquals("A", list.head.next().element());
        assertEquals("A", list.curr.next().element());
        assertEquals("E", list.tail.element());
        list.append("I");
        assertEquals(3, list.length());
        assertEquals("A", list.head.next().element());
        assertEquals("A", list.curr.next().element());
        assertEquals("I", list.tail.element());
        assertNull(list.head.element());
        assertNull(list.curr.element());
        assertNotNull(list.tail.element());


    }

    @Test
    public void remove() {
        list.append("A");
        list.append("E");
        list.append("I");
        assertEquals(0, list.currPos());
        assertEquals("A", list.head.next().element());
        assertEquals("I", list.tail.element());
        assertEquals(3, list.length());
        list.remove();
        assertEquals("E", list.head.next().element());
        assertEquals("I", list.tail.element());
        assertEquals(2, list.length());

    }

    @Test
    public void moveToStart() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        assertEquals(0, list.currPos());
        list.moveToPos(2);
        assertEquals(2, list.currPos());
        list.moveToStart();
        assertEquals(0, list.currPos());


    }

    @Test
    public void moveToEnd() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        assertEquals(0, list.currPos());
        list.moveToEnd();
        assertEquals(3, list.currPos());
    }

    @Test
    public void prev() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        list.moveToEnd();
        assertEquals(3, list.currPos());
        list.prev();
        assertEquals(2, list.currPos());
    }

    @Test
    public void next() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        list.next();
        assertEquals(1, list.currPos());
    }

    @Test
    public void length() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        assertEquals(3, list.length());
    }

    @Test
    public void currPos() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        assertEquals(0, list.currPos());
    }

    @Test
    public void moveToPos() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        list.moveToPos(2);
        assertEquals(2, list.currPos());
        assertEquals("A", list.curr.next().element());
    }

    @Test
    public void getValue() {
        list.insert("A");
        list.insert("E");
        list.insert("I");
        assertEquals("I", list.getValue());
        list.moveToPos(1);
        assertEquals("E", list.getValue());
    }
}