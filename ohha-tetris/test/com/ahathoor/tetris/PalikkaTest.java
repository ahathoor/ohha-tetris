/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.Board.Palikka;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mothi
 */
public class PalikkaTest {
    
    public PalikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setColor method, of class Palikka.
     */
    @Test
    public void testSetColor() {
    }

    /**
     * Test of getColor method, of class Palikka.
     */
    @Test
    public void testGetColor() {
    }

    /**
     * Test of isEmpty method, of class Palikka.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Palikka instance = new Palikka();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStopped method, of class Palikka.
     */
    @Test
    public void testIsStopped() {
        System.out.println("isStopped");
        Palikka instance = new Palikka();
        boolean expResult = true;
        boolean result = instance.isStopped();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilled method, of class Palikka.
     */
    @Test
    public void testSetFilled() {
        System.out.println("setFilled");
        Palikka instance = new Palikka();
        instance.setFilled(true);
        assertEquals(true,!instance.isEmpty());
        instance.setFilled(false);
        assertEquals(true,instance.isEmpty());
    }

    /**
     * Test of setStopped method, of class Palikka.
     */
    @Test
    public void testSetStopped() {
        System.out.println("setStopped");
        boolean s = false;
        Palikka instance = new Palikka();
        instance.setStopped(s);
    }

    /**
     * Test of clear method, of class Palikka.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Palikka instance = new Palikka();
        instance.clear();
    }
}
