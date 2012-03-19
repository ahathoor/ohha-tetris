/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mothi
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.ahathoor.tetris.AppTest.class, com.ahathoor.tetris.TetrisAlustaTest.class, com.ahathoor.tetris.PalikkaRiviTest.class, com.ahathoor.tetris.TetrisIkkunaTest.class, com.ahathoor.tetris.PalikkaTest.class, com.ahathoor.tetris.TetrisPanelTest.class})
public class TetrisSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
