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
        System.out.println("setColor");
        int[] rgb = {100,100,100};
        int[] expected = {100,100,100};
        Palikka instance = new Palikka();
        instance.setColor(rgb);
        assertEquals(instance.getColor()[0],expected[0]);
        rgb[0] = -11;
        instance.setColor(rgb);
        assertEquals(instance.getColor()[0],expected[0]);
        rgb[0] = 9999;
        instance.setColor(rgb);
        assertEquals(instance.getColor()[0],expected[0]);
        int[] toolong = {20,5,2,3};
        instance.setColor(toolong);
        assertEquals(instance.getColor()[0],expected[0]);
    }

    /**
     * Test of getColor method, of class Palikka.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Palikka instance = new Palikka();
        instance.setColor(new int[] {255,255,255});
        int[] expResult = {255,255,255};
        int[] result = instance.getColor();
        assertEquals(expResult[0], result[0]);
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

    /**
     * Test of copyAttributes method, of class Palikka.
     */
    @Test
    public void testCopyAttributes() {
        System.out.println("copyAttributes");
        Palikka p = new Palikka();
        int[] rgb = {123,123,123};
        p.setColor(rgb);
        Palikka instance = new Palikka();
        instance.copyAttributes(p);
        assertEquals(rgb[0],instance.getColor()[0]);
    }
}
