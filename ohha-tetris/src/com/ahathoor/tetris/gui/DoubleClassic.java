/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.ColorStuff.JustRed;
import com.ahathoor.tetris.ColorStuff.JustYellow;
import com.ahathoor.tetris.logic.Ilmoittaja;
import com.ahathoor.tetris.logic.PeliSettings_Classic;
import com.ahathoor.tetris.logic.Pelinkulku;
import com.ahathoor.tetris.gui.painters.BoardPainter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ahathoor
 */
public class DoubleClassic extends PeliPanel {
    
    private Pelinkulku peli;
    private Pelinkulku peli2;
    private BoardPainter lauta;
    private BoardPainter lauta2;
    private BoardPainter seuraavapala;
    private BoardPainter seuraavapala2;
    private Ilmoittaja ilmoittaja;
    
    public DoubleClassic(MainWindow kutsuva) {
        super(kutsuva);    
        peli = new Pelinkulku(new PeliSettings_Classic());
        peli2 = new Pelinkulku(new PeliSettings_Classic());
        ilmoittaja = peli.getIlmoittaja();
        lauta = new BoardPainter(200,400,50,30,peli.getBoard(),peli);
        lauta.forceAlpha = true;
        lauta.forcedAlpha = 200;
        lauta2 = new BoardPainter(200,400,50,30,peli2.getBoard(),peli2);
        lauta2.setInverted(true);
        lauta2.forceAlpha = true;
        lauta2.forcedAlpha = 200;
        seuraavapala = new BoardPainter(50,50,290,80,peli.getMiniboard(),peli);
        seuraavapala2 = new BoardPainter(50,50,290,300,peli2.getMiniboard(),peli2);
        peli.setColorfeeder(new JustYellow());
        peli2.setColorfeeder(new JustRed());
        peli.startGame();
        peli2.startGame();
        setVisible(true);
    }
    @Override
    public void tick() {
        super.tick();
        if (peli.getConfig().gamelost || peli2.getConfig().gamelost) {
            LosePanel losepanel = new LosePanel(kutsuvaIkkuna, "DoubleClassic", peli.getScore()+peli2.getScore());
            kutsuvaIkkuna.usePanel(losepanel);
            kutsuvaIkkuna.score("DoubleClassic", peli.getScore()+peli2.getScore());
        }
        peli.step();
        peli2.step();
    }
        @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        lauta.paint(g);
        lauta2.paint(g);
        seuraavapala.paint(g);
        seuraavapala2.paint(g);
        char[] score = ((peli.getScore()+peli2.getScore()) + "").toCharArray();
        g.setColor(Color.green);
        g.setFont(new Font("Console",Font.BOLD,20));
        g.drawChars(score, 0,score.length, 280, 160);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       if (ke.getKeyCode()==37) peli.left();
       if (ke.getKeyCode()==39) peli.right();
       if (ke.getKeyCode()==38) peli.flip();
       if (ke.getKeyCode()==40) peli.down();
       if (ke.getKeyChar()=="s".charAt(0)) peli2.down();
       if (ke.getKeyChar()=="a".charAt(0)) peli2.left();
       if (ke.getKeyChar()=="w".charAt(0)) peli2.flip();
       if (ke.getKeyChar()=="d".charAt(0)) peli2.right();
       if (ke.getKeyCode()==113) {
           peli.startGame();
           peli2.startGame();
       }
       if (ke.getKeyChar()=="p".charAt(0)) {
           peli.pause();
           peli2.pause();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
