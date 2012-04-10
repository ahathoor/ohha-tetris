/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.Board.PalikkaRivi;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mothi
 */
public class PalikkaRiviTest {
    
    public PalikkaRiviTest() {
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
     * Test of getPalikat method, of class PalikkaRivi.
     */
    @Test
    public void testPalikkaRivi() {
        PalikkaRivi instance = new PalikkaRivi(120);
        assertEquals(100,instance.getSize());
        instance = new PalikkaRivi(-11);
        assertEquals(1,instance.getSize());
    }
}
