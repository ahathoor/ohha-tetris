/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.gui.painters.BoardPainter;
import com.ahathoor.tetris.logic.Ilmoittaja;
import com.ahathoor.tetris.logic.Pelinkulku;
import com.ahathoor.tetris.logic.PeliSettings_Classic;
import com.ahathoor.tetris.gui.painters.LightFlashPainter;
import com.ahathoor.tetris.logic.Ilmoitus;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;

/**
 *
 * @author ahathoor
 */
public class ClassicPanel extends PeliPanel {
    
    private Pelinkulku peli;
    private BoardPainter lauta;
    private BoardPainter seuraavapala;
    private Ilmoittaja ilmoittaja;
    
    public ClassicPanel(MainWindow kutsuva) {
        this(kutsuva, new PeliSettings_Classic());
    }
    public ClassicPanel(MainWindow kutsuva, PeliSettings_Classic p) {
        super(kutsuva);    
        peli = new Pelinkulku(p);
        ilmoittaja = peli.getIlmoittaja();
        lauta = new BoardPainter(200,400,50,30,peli.getBoard(),peli);
        seuraavapala = new BoardPainter(50,50,290,80,peli.getMiniboard(),peli);
        peli.startGame();
        setVisible(true);
    }
    @Override
    public void tick() {
        super.tick();
        if (peli.getConfig().gamelost) {
            LosePanel losepanel = new LosePanel(kutsuvaIkkuna,peli.getConfig().modename,peli.getScore());
            kutsuvaIkkuna.usePanel(losepanel);
            kutsuvaIkkuna.score(peli.getConfig().modename, peli.getScore());
        }
        peli.step();
    }
        @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.pink);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        lauta.paint(g);
        seuraavapala.paint(g);
        char[] data = (peli.getScore() + "").toCharArray();
        g.setColor(Color.green);
        g.setFont(new Font("Console",Font.BOLD,20));
        g.drawChars(data, 0,data.length, 280, 160);
        
        Iterator i = peli.getIlmoittaja().getIlmoitukset().iterator();
            while (i.hasNext()) {
                Ilmoitus il = (Ilmoitus)i.next(); 
                int kesto = il.getKesto();
                int alkukesto = il.getAlkukesto();
                String viesti = il.getNimi();
                float suhde = (float)kesto/(float)alkukesto;
                int rivi = Integer.parseInt(viesti.split("#")[1]);
                int alpha = (int) (200 * suhde);
                LightFlashPainter.paint(g, lauta.getOffset_x(), 
                                lauta.getOffset_y()+lauta.getHeight()-(lauta.getBlockHeight()*(rivi+1)), 
                                lauta.getWidth(), 
                                lauta.getBlockHeight(), 
                                alpha);
            }
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
       if (ke.getKeyChar()=="s".charAt(0)) peli.up();
       if (ke.getKeyChar()=="d".charAt(0)) peli.stop();
       if (ke.getKeyCode()==113) {
           peli.startGame();
       }
       if (ke.getKeyChar()=="p".charAt(0)) {
           peli.pause();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
