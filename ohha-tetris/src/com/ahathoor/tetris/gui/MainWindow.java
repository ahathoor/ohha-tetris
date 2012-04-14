/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import com.ahathoor.tetris.highscore.HighScores;
import com.ahathoor.tetris.highscore.Score;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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
        setTitle("TETTURISSY!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,500);
        timer = new Timer(20, tick);
        this.usePanel(new MenuPanel(this));
    }
    public void score(String gamemode, int score) {
        if (highScores.canTakeScore(gamemode, score))
            highScores.putScore(gamemode, askName(), score);
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
        this.requestFocusInWindow(true);
    }

    public HighScores getHighScores() {
        return highScores;
    }
    public String askName() {
        return (String)JOptionPane.showInputDialog(this, 
                        "HAI SCORUUUUUUUUUUUU!!!!!!!","Put Name");
    }
}