/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Palikka;
import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.PisteLaskuri;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Label;
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
    
    private Pelinkulku peli;
    private TetrisPanel lauta;
    private Label score;
    private PisteLaskuri counter;
    
    public TetrisIkkuna(Pelinkulku moodi) throws HeadlessException{
        super();    
        peli = moodi;
        counter = peli.getPistelaskuri();
        
        //Action Listeners//
        ActionListener vasen = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                peli.left();
                lauta.repaint();
                }
            };
        ActionListener kaanna = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                peli.flip();
                lauta.repaint();
                }
            };
        ActionListener tick = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                peli.step();
                lauta.repaint();
                score.setText(counter.toString());
                }
            };
        //Main window init//
        setTitle("Tetturissy!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 420);
        //Timer init//
        Timer timer = new Timer(40, tick);
        timer.start(); 
        //The main panel where everything is drawn /
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        //The actual tetris board /
        lauta = new TetrisPanel(peli.getBoard());
        lauta.setPreferredSize(new Dimension(200, 400));
        mainpanel.add(lauta);
        //Scoreboard
        score = new Label("");
        score.setPreferredSize(new Dimension(50,20));
        mainpanel.add(score);
        //Add and pack and listen/
        add(mainpanel);
        pack();
        setVisible(true);
        mainpanel.addKeyListener(this);
        mainpanel.requestFocus();
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
   
