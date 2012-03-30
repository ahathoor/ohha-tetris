package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import java.awt.HeadlessException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws HeadlessException
    {
        TetrisIkkuna f = new TetrisIkkuna(new Pelinkulku());
    }
}
