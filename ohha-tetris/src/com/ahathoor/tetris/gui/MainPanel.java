/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.PisteLaskuri;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author mkctammi
 */
public class MainPanel extends JPanel{
    
    private Pelinkulku peli;
    private BoardPainter lauta;
    private BoardPainter seuraavapala;
    private PisteLaskuri counter;
    private LoseScreenPainter losepaint = new LoseScreenPainter();
    private MenuScreenPainter menupaint = new MenuScreenPainter();
    
    public MainPanel(Pelinkulku moodi) throws HeadlessException{
        super();    
        peli = moodi;
        counter = peli.getPistelaskuri();
        lauta = new BoardPainter(200,400,50,30,peli.getBoard());
        seuraavapala = new BoardPainter(50,50,290,80,peli.getMiniboard());
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (peli.getConfig().MENUSCREEN) {
            menupaint.paint(g);
            return;
        }
        if (peli.getConfig().GAMELOST) {
            losepaint.paint(g,peli.getPistelaskuri().getScore());
            return;
        }
        g.setColor(Color.pink);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        lauta.paint(g);
        seuraavapala.paint(g);
        char[] data = peli.getPistelaskuri().toString().toCharArray();
        g.setColor(Color.green);
        g.setFont(new Font("Console",Font.BOLD,20));
        g.drawChars(data, 0,data.length, 280, 160);
    }


    
}
   
