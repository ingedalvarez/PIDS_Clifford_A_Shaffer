package org.ingedalvarez.ch4.towerofhanoi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PoleTest {
    Pole pole;
    @Before
    public void setUp() throws Exception {
        pole = new Pole("Pole 1", 4);
        pole.populateStack(4);
    }

    @After
    public void tearDown() throws Exception {
        pole = null;
    }

    @Test
    public void getPole() {
        assertEquals(4, pole.getPole().length());
        assertEquals(1, (long)pole.getPole().pop());
        assertEquals(2, (long)pole.getPole().pop());
        assertEquals(3, (long)pole.getPole().pop());
        assertEquals(4, (long)pole.getPole().pop());

    }

    @Test
    public void print(){
        System.out.println(pole);
    }

}