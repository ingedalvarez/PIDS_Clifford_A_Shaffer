package org.ingedalvarez.ch4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkTest {
    Link<String> node, nodeN;
    @Before
    public void setUp() throws Exception {
        nodeN = new Link<>(null);
        node = new Link<>(nodeN);
    }

    @Test
    public void next() {
        assertEquals(nodeN, node.next());
    }

    @Test
    public void setNext() {
        Link<String> node2 = new Link<>("A",null);
        node.setNext(node2);
        assertEquals(node2, node.next());
    }

    @Test
    public void setElement() {
        node.setElement("E");
        assertEquals("E", node.element());
    }

    @Test
    public void element() {
        node.setElement("E");
        assertEquals("E", node.element());
    }
}