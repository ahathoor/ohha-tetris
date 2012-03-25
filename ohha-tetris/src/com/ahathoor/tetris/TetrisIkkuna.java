/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mkctammi
 */
public class TetrisIkkuna extends JFrame implements KeyListener{
    
    Pelinkulku peli = new Pelinkulku();
    TetrisPanel tetrisPanel = new TetrisPanel(peli.getBoard());
    
    
    //Action Listeners
    ActionListener vasen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       peli.left();
               tetrisPanel.repaint();
            }
        };
    ActionListener kaanna = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       peli.flip();
               tetrisPanel.repaint();
            }
        };
    ActionListener tick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       peli.step();
               tetrisPanel.repaint();
            }
        };
    
    public TetrisIkkuna() throws HeadlessException{
        super();
        setTitle("Tetturissy!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        Timer timer = new Timer(200, tick);
        timer.start(); 
        
        JPanel paneeli = new JPanel();
        tetrisPanel.setPreferredSize(new Dimension(200, 400));
        
        paneeli.add(tetrisPanel);
        
        add(paneeli);
        Palikka testi = new Palikka();
        testi.setFilled(true);
        testi.setStopped(false);
        pack();
        setVisible(true);
        
        paneeli.addKeyListener(this);
        paneeli.requestFocus();
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
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
}
   
