/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;

/**
 *
 * @author mkctammi
 */
public class TetrisIkkuna extends JFrame {
/**
 * Konstruktoi TetrisIkkunan
 * @throws HeadlessException 
 */
    public TetrisIkkuna() throws HeadlessException, Exception {
        super();
        setTitle("Tetturissy!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        TetrisPanel tetrisPanel = new TetrisPanel(new TetrisAlusta());
        add(tetrisPanel);
        setVisible(true);
    }
    
}
