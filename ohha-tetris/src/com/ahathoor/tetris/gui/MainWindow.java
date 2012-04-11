/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author ahathoor
 */
public class MainWindow extends JFrame implements KeyListener {
    
    private Pelinkulku peli;
    private MainPanel mainpanel;
    
    
    public MainWindow() throws HeadlessException {
        peli = new Pelinkulku();
        mainpanel = new MainPanel(peli);
        
        ActionListener tick = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                peli.step();
                mainpanel.repaint();
                }
            };
        //Timer init//
        Timer timer = new Timer(20, tick);
        timer.start(); 
        
        setTitle("TETTURISSY!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,500);
        add(mainpanel);
        mainpanel.setPreferredSize(new Dimension(380,500));
        setVisible(true);
        addKeyListener(this);
    
    }
        @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       if (ke.getKeyCode()==37) peli.left();
       if (ke.getKeyCode()==39) peli.right();
       if (ke.getKeyCode()==38) peli.up();
       if (ke.getKeyCode()==40) peli.down();
       if (ke.getKeyCode()==113 && !peli.getConfig().RUNNING) {
           peli.getConfig().GAMELOST = false;
           peli.getConfig().RUNNING = true;
           peli.getConfig().MENUSCREEN = false;
           peli.getBoard().poistaKaikki();
           peli.getPistelaskuri().setScore(0);
       }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
