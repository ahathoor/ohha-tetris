/*
 * Paneeli, joka piirtää TetrisAlustan
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Palikka;
import com.ahathoor.tetris.TetrisAlusta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mothi
 */
public class TetrisPanel extends JPanel{
    
    private TetrisAlusta alusta;
    
    public TetrisPanel(TetrisAlusta b){
        alusta = b;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
        
        int palikanLeveys = this.getWidth()/alusta.getLeveys();
        int palikanKorkeus = this.getHeight()/alusta.getKorkeus();
       
        
        for (int x=0;x<alusta.getLeveys();x++) {
            for (int y = 0;y<alusta.getKorkeus();y++) {
                Palikka tutkittava = alusta.getPalikkaAt(x,y);
                if (tutkittava.isEmpty()){
                    g.setColor(Color.black);
                    g.drawRect(getWidth() - palikanLeveys * (x+1),this.getHeight()-palikanKorkeus*(y+1),palikanLeveys,palikanKorkeus);
                } else {
                    int[] rgb = tutkittava.getColor();
                    g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
                    g.fillRect(getWidth() -palikanLeveys * (x+1),this.getHeight()-palikanKorkeus*(y+1),palikanLeveys,palikanKorkeus);
                }
            }
        }
    }
}
