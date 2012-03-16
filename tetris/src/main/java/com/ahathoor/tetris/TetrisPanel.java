/*
 * Paneeli, joka piirtää TetrisAlustan
 */
package com.ahathoor.tetris;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author mothi
 */
public class TetrisPanel extends JPanel {
    
    private TetrisAlusta alusta;
    public TetrisPanel(TetrisAlusta b){
        alusta = b;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(200,50, 20,40);     // nelikulmio, vasen nurkka, leveys, korkeus
    }
}
