/*
 * Piirtää annettua TetrisAlustaa
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Board.Palikka;
import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.Board.TetrisAlusta;
import com.ahathoor.tetris.TetrisSettings;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mothi
 */
public class BoardPainter{
    
    private TetrisSettings config;
    private TetrisAlusta alusta;
    private Pelinkulku peli;
    private int width;
    private int height;
    private int offset_x;
    private int offset_y;
    
    public BoardPainter(int w, int h, int offX, int offY, TetrisAlusta t){
        width = w;
        height = h;
        alusta = t;
        offset_x = offX;
        offset_y = offY;
        peli = t.getKuuluuPeliin();
        config = peli.getConfig();
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        
        int palikanLeveys = width/alusta.getLeveys();
        int palikanKorkeus = height/alusta.getKorkeus();
       
        
        for (int x=0;x<alusta.getLeveys();x++) {
            for (int y = 0;y<alusta.getKorkeus();y++) {
                Palikka tutkittava = alusta.getPalikkaAt(x,y);
                
                //draw the blox
                if (!tutkittava.isEmpty()) {
                    int[] rgb = tutkittava.getColor();
                    g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
                    g.fillRect(offset_x + width -palikanLeveys * (x+1),
                            offset_y + this.height-palikanKorkeus*(y+1),
                            palikanLeveys,palikanKorkeus);
                }
                
                //draw the grid
                g.setColor(Color.white);
                if(!config.INVISIBULU) g.drawRect(offset_x + width -palikanLeveys * (x+1),
                            offset_y + this.height-palikanKorkeus*(y+1),
                            palikanLeveys,palikanKorkeus);
            }
        }
    }
}
