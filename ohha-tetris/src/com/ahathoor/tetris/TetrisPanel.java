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
    public TetrisPanel() {
        return;
    }
    public TetrisPanel(TetrisAlusta b){
        alusta = b;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int palikanLeveys = this.getWidth()/alusta.getLeveys();
        int palikanKorkeus = this.getHeight()/alusta.getKorkeus();
        
        for (int x=0;x<alusta.getLeveys();x++) {
            for (int y = 0;y<alusta.getKorkeus();y++) {
                if (alusta.getPalikkaAt(x,y).isEmpty()){
                    g.drawRect(palikanLeveys * x,palikanKorkeus*y,palikanLeveys,palikanKorkeus);
                } else {
                    g.fillRect(palikanLeveys * x,palikanKorkeus*y,palikanLeveys,palikanKorkeus);
                }
            }
        }
    }
}
