/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.PisteLaskuri;
import com.ahathoor.tetris.PerusPeliSettings;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author ahathoor
 */
public class ClassicPanel extends PeliPanel {
    
    private Pelinkulku peli;
    private BoardPainter lauta;
    private BoardPainter seuraavapala;
    
    public ClassicPanel(MainWindow kutsuva) {
        super(kutsuva);    
        peli = new Pelinkulku(new PerusPeliSettings());
        lauta = new BoardPainter(200,400,50,30,peli.getBoard());
        seuraavapala = new BoardPainter(50,50,290,80,peli.getMiniboard());
        peli.startGame();
        setVisible(true);
    }
    @Override
    public void tick() {
        super.tick();
        peli.step();
    }
        @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (peli.getConfig().gamelost) {
            kutsuvaIkkuna.TAPPIORUUTU.setScore(peli.getScore());
            kutsuvaIkkuna.usePanel(kutsuvaIkkuna.TAPPIORUUTU);
        }
        g.setColor(Color.pink);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        lauta.paint(g);
        seuraavapala.paint(g);
        char[] data = (peli.getScore() + "").toCharArray();
        g.setColor(Color.green);
        g.setFont(new Font("Console",Font.BOLD,20));
        g.drawChars(data, 0,data.length, 280, 160);
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
       if (ke.getKeyChar()=="S".charAt(0)) peli.up();
       if (ke.getKeyCode()==113) {
           peli.startGame();
       }
       if (ke.getKeyCode()==114) {
           peli.pause();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}