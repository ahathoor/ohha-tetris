/*
 * Piirtää annettua TetrisAlustaa
 */
package com.ahathoor.tetris.gui.painters;

import com.ahathoor.tetris.Board.Palikka;
import com.ahathoor.tetris.Board.TetrisAlusta;
import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.PeliSettings_Classic;
import com.ahathoor.tetris.ColorStuff.Color;
import java.awt.Graphics;

/**
 *
 * @author mothi
 */
public class BoardPainter{
    
    private PeliSettings_Classic config;
    private TetrisAlusta alusta;
    private Pelinkulku peli;
    private int width;
    private int height;
    private int offset_x;
    private int offset_y;
    public boolean forceAlpha = false;
    public int forcedAlpha = 150;
    public Color gridColor = Color.white;
    
    
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
        
        int palikanLeveys = width/alusta.getLeveys();
        int palikanKorkeus = height/alusta.getKorkeus();
       
        
        for (int x=0;x<alusta.getLeveys();x++) {
            for (int y = 0;y<alusta.getKorkeus();y++) {
                Palikka tutkittava = alusta.getPalikkaAt(x,y);
                
                //draw the blox
                if (tutkittava.ghost) {
                    Color ghostcolor = tutkittava.ghostcolor;
                    if (forceAlpha) ghostcolor.setAlpha(forcedAlpha);
                    g.setColor(ghostcolor.getAwtColor());
                    g.fillRect(offset_x + width -palikanLeveys * (x+1),
                            offset_y + this.height-palikanKorkeus*(y+1),
                            palikanLeveys,palikanKorkeus);
                }
                if (!tutkittava.isEmpty()) {
                    Color block = tutkittava.getColor();
                    if (forceAlpha) block.setAlpha(forcedAlpha);
                    g.setColor(block.getAwtColor());
                    g.fillRect(offset_x + width -palikanLeveys * (x+1),
                            offset_y + this.height-palikanKorkeus*(y+1),
                            palikanLeveys,palikanKorkeus);
                }
                
                //draw the grid
                g.setColor(gridColor.getAwtColor());
                if(!config.INVISIBULU) g.drawRect(offset_x + width -palikanLeveys * (x+1),
                            offset_y + this.height-palikanKorkeus*(y+1),
                            palikanLeveys,palikanKorkeus);
            }
        }
    }
}
