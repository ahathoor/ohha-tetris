/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.Board.TetrisAlusta;
import com.ahathoor.tetris.Board.Palikka;
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
        TetrisAlusta instance = new TetrisAlusta(20,20);
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
        TetrisAlusta instance = new TetrisAlusta(20,20);
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
        TetrisAlusta instance = new TetrisAlusta(20,20);
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
        TetrisAlusta instance = new TetrisAlusta(20,20);
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
        t.setStopped(false);
        TetrisAlusta instance = new TetrisAlusta(20,20);
        instance.LisaaPalikka(x, y, t);
        assertEquals(false,instance.getPalikkaAt(x, y).isStopped());
    }
}
