/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mothi
 */
public class TetrisAlustaTest {
    
    public TetrisAlustaTest() {
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
     * Test of getLeveys method, of class TetrisAlusta.
     */
    @Test
    public void testGetLeveys() {
        System.out.println("getLeveys");
        TetrisAlusta instance = new TetrisAlusta();
        int expResult = 10;
        int result = instance.getLeveys();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKorkeus method, of class TetrisAlusta.
     */
    @Test
    public void testGetKorkeus() {
        System.out.println("getKorkeus");
        TetrisAlusta instance = new TetrisAlusta();
        int expResult = 20;
        int result = instance.getKorkeus();
        assertEquals(expResult, result);
    }

    /**
     * Test of shiftBlocks method, of class TetrisAlusta.
     */
    @Test
    public void testShiftBlocks() {
        System.out.println("shiftBlocks");
        TetrisAlusta instance = new TetrisAlusta();
        boolean expResult = true;
        boolean result = instance.shiftBlocks(0,0);
        assertEquals(expResult, result);
    }

    /**
     * Test of flipBlock method, of class TetrisAlusta.
     */
    @Test
    public void testFlipBlock() {
        System.out.println("flipBlock");
        TetrisAlusta instance = new TetrisAlusta();
        instance.flipBlock();
    }

    /**
     * Test of LisaaPalikka method, of class TetrisAlusta.
     */
    @Test
    public void testLisaaPalikka() {
        System.out.println("LisaaPalikka");
        int x = 0;
        int y = 0;
        Palikka t = new Palikka();
        t.setColor(new int[] {111,222,333});
        TetrisAlusta instance = new TetrisAlusta();
        instance.LisaaPalikka(x, y, t);
        int blue = instance.getPalikkaAt(x,y).getColor()[2];
        assertEquals(333,blue);
    }

    /**
     * Test of getPalikkaAt method, of class TetrisAlusta.
     */
    @Test
    public void testGetPalikkaAt() {
        System.out.println("getPalikkaAt");
        int x = 0;
        int y = 0;
        TetrisAlusta instance = new TetrisAlusta();
        instance.getPalikkaAt(x, y).setColor(new int[]{200,200,200});
        Palikka result = instance.getPalikkaAt(x, y);
        assertEquals(200, result.getColor()[0]);
    }
}
