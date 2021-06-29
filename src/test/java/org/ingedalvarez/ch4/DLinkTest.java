package org.ingedalvarez.ch4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLinkTest {

    DLink<String> node, nodeN, nodeP;
    @Before
    public void init(){
        nodeN = new DLink<>(null, null);
        nodeP = new DLink<>(null, null);
        node = new DLink<>(nodeN, nodeP);
    }

    @Test
    public void next() {
        assertEquals(nodeN, node.next());
    }

    @Test
    public void prev() {
        assertEquals(nodeP, node.prev());
    }

    @Test
    public void setNext() {
        DLink<String> node2 = new DLink<String>(null, null);
        node.setNext(node2);
        assertEquals(node2, node.next());
    }

    @Test
    public void setPrev() {
        DLink<String> node2 = new DLink<String>(null, null);
        node.setPrev(node2);
        assertEquals(node2, node.prev());
    }

    @Test
    public void element() {
        node.setElement("A");
        assertEquals("A", node.element());
    }

    @Test
    public void setElement() {
        node.setElement("A");
        assertEquals("A", node.element());
    }
}