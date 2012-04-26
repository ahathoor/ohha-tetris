/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.logic.Pelinkulku;
import com.ahathoor.tetris.highscore.HighScores;
import com.ahathoor.tetris.highscore.Score;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author ahathoor
 */
public class MainWindow extends JFrame {
    
    private PeliPanel mainpanel;
    private ActionListener tick;
    private Timer timer;
    private String scorePath = "data/scores.dat";
    private HighScores highScores = new HighScores(scorePath);
    
    public MainWindow() throws HeadlessException {
        this.setTitle("TETTURISSY!!!!!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setSize(380,500);
        timer = new Timer(20, tick);
        this.usePanel(new MenuPanel(this));
        this.requestFocus();
    }
    public void score(String gamemode, int score) {
        if (highScores.canTakeScore(gamemode, score)) {
            String name = askName();
            highScores.putScore(gamemode, name, score);
        }
        highScores.writeToFile(scorePath);
    }   
    final public void usePanel(PeliPanel p) {
        for (KeyListener k : this.getKeyListeners()){
            this.removeKeyListener(k);
        }
        
        if (tick != null) timer.removeActionListener(tick);
        if (mainpanel != null) this.remove(mainpanel);
        mainpanel = p;
        add(mainpanel);
        mainpanel.setPreferredSize(new Dimension(380,500));
        addKeyListener(mainpanel);
        
        tick = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainpanel.tick();
                }
            };
        setVisible(true);
        timer.addActionListener(tick);
        timer.start();
        this.requestFocus();
        mainpanel.revalidate();
    }

    public HighScores getHighScores() {
        return highScores;
    }
    
    private class Kuuntelija implements ActionListener {
        
        String nimi; 
        JTextField teksti;

        public Kuuntelija(JTextField teksti) {
            this.teksti = teksti;
        }
        
            @Override
            public void actionPerformed(ActionEvent ae) {
                nimi = teksti.getText();
            }
    }
    
    public String askName() {
        return JOptionPane.showInputDialog(this, "HIGH SCORUUUUUUUU!!!!");
    }
}